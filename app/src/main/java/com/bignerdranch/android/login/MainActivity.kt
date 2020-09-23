package com.bignerdranch.android.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.login.model.Login
import com.bignerdranch.android.login.repository.Repository
import com.bignerdranch.android.login.utils.Constants.Companion.AUTH_TOKEN


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Email = findViewById<EditText>(R.id.editTextTextEmailAddress).text
        val Password = findViewById<EditText>(R.id.editTextTextPassword).text
        val LoginButton = findViewById<Button>(R.id.button)

        //val sharedPreferense:SharedPreference= SharedPreference(this)
       // var myGlobal = SharedPreference()

        LoginButton.setOnClickListener{
            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

            val login = Login(Email.toString(),Password.toString(),"")
            viewModel.Auth(login)
            viewModel.myResponse.observe(this, Observer {response->
                val any = if (response.body()?.token!!.isNotEmpty() ) {

                    Log.d("Response", "1" + response.code().toString())
                   // Log.d("Response", "2" + response.body()?.token.toString())
                    Log.d("Response", "3" + response.headers().toString())

                    //sharedPreferense.save("auth", response.body()?.token!!)
//                    myGlobal.save(response.body()?.token!!)

                    //Log.d("Response", "2" + myGlobal)
                    val intent = Intent(this, UserInfo::class.java).apply {
                    putExtra(AUTH_TOKEN, response.body()?.token)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}