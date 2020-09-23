package com.bignerdranch.android.login.api

import com.bignerdranch.android.login.SharedPreference
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor: Interceptor {

   //private sharedPreferense: SharedPreference = SharedPreference(MainActivity::class.java)

   // Log.d("MYINT", )

//    val myApp = SharedPreference()
//
//    val myGlobal = myApp.getValue()
//
//    Log.d("MYINT", myGlobal)


    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("Authorization","Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VyIjp7ImlkIjoiMWVjanJEM0tYdVhzM0hoMVJSNGgwcFloa0JtIiwibmFtZSI6IkFsaW5hIFMiLCJlbWFpbCI6InRlc3RhbGluYUBtYWlsc2Vjdi5jb20iLCJwYXNzd29yZCI6IiQyYSQxMCR1RXdxZHVTZmdWcW0uYkthZTZVWVllOFB4bEo3cHF1YmdHTWxwdXhOaVdyaUtXdUJOL000UyIsImxhbmd1YWdlIjoiZW4iLCJwaG9uZSI6Iis3NzA1NDI0MTIyNCIsImJsb2NrZWQiOmZhbHNlLCJhdmF0YXIiOiIiLCJwb3NpdGlvbiI6Ik1hbmFnZXIiLCJjb21wYW55X2lkIjoiMWVjanJCMlRUTWpUMWdpVGtqcXBYR2Q4WUVGIiwiYWxsb3dfZ3NtX2NhbGxzIjpmYWxzZSwiYWxsb3dfY2FsbHNfd2l0aF9kdXJhdGlvbiI6ZmFsc2UsInNlY3Rpb25zIjpudWxsLCJvcGVyYXRvcl9pZCI6MCwiYWRkaXRpb25hbF9vcGVyYXRvcnNfaWRzIjpudWxsLCJjYXJyaWVyX21hcF9uYW1lIjoiIiwiY3JlYXRlZF9hdCI6IjIwMjAtMDctMTNUMDg6MTI6NTEuNTQyOFoiLCJhbGxvd19tYXhpbXVtX3VuaXF1ZSI6ZmFsc2UsImNvdW50X2NhbGxzX3dpdGhfZHVyYXRpb24iOjAsImZyYXVkX3R5cGVzX3dpdGhfZHVyYXRpb24iOm51bGwsImFsbG93ZWRfb3BlcmF0b3JzX3dpdGhfZHVyYXRpb24iOm51bGwsImFsbG93ZWRfbmV0X2EiOm51bGwsIm1heF90YXNrX2ludGVuc2l2aXR5IjowLCJ3aXRob3V0X2NvbXBhbnkiOmZhbHNlfSwiZXhwIjoxNjAwODUwMDM4LCJpc3MiOiJ0b2tlbi5waW5nb2NlYW4uY29tIn0.acYfCeo38vEXcOixjzvfrOZcEGxWNkkv_0XXaI6R3BM")
            .build()
        return chain.proceed(request)
    }
}