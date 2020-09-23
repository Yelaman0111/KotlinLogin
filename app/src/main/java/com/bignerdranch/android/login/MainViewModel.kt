package com.bignerdranch.android.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.login.model.Login
import com.bignerdranch.android.login.model.User
import com.bignerdranch.android.login.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val myResponse: MutableLiveData<Response<Login>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<User>> = MutableLiveData()

    fun Auth(login: Login){
        viewModelScope.launch {
            val response: Response<Login> = repository.Auth(login)
            myResponse.value = response
        }
    }

    fun getUser(auth: String){
        viewModelScope.launch {
            val response: Response<User> = repository.getUser(auth)
            myResponse2.value = response
        }
    }
}