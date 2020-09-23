package com.bignerdranch.android.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.login.model.Login
import com.bignerdranch.android.login.repository.Repository
import com.bignerdranch.android.login.utils.Constants
import com.bignerdranch.android.login.utils.Constants.Companion.AUTH_TOKEN
import org.w3c.dom.Text

class UserInfo : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)



        val auth_Token = intent.getStringExtra(AUTH_TOKEN)

        val id = findViewById<TextView>(R.id.id_tv)
        val name = findViewById<TextView>(R.id.name_tv)
        val email = findViewById<TextView>(R.id.email_tv)
        val phone = findViewById<TextView>(R.id.phone_tv)
        val avatar = findViewById<ImageView>(R.id.avatar_img)
        val position = findViewById<TextView>(R.id.position_tv)
        val company_name = findViewById<TextView>(R.id.company_name_tv)
        val time_zone = findViewById<TextView>(R.id.time_zone_tv)

        val logout = findViewById<Button>(R.id.LogOut)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getUser("Bearer $auth_Token")
        viewModel.myResponse2.observe(this, Observer { response ->
            if (response.isSuccessful) {
                id.text = response.body()?.id
                name.text = response.body()?.name
                email.text = response.body()?.email
                phone.text = response.body()?.phone

                position.text = response.body()?.position
                company_name.text = response.body()?.company_name
                time_zone.text = response.body()?.timezone

                Log.d("Response", auth_Token)
                Log.d("Response", "1" + response.code().toString())
                Log.d("Response", "2" + response.body()?.name)
                Log.d("Response", "3" + response.headers())
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }


        })

        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                //putExtra(AUTH_TOKEN, sharedPreference.getString(Constants.PREF_TOKEN, ""))
            }
            startActivity(intent)
//           val  sPref = getSharedPreferences(PREF_TOKEN, Context.MODE_PRIVATE)
//            Log.d("SPREF", sPref.getString(PREF_TOKEN,"").toString())

        }
    }
}