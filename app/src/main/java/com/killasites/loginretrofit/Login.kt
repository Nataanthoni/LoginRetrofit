package com.killasites.loginretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.killasites.loginretrofit.network.LoginResponse
import com.killasites.loginretrofit.services.Api
import com.killasites.loginretrofit.services.RetrofitClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: RetrofitClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Perform all these when the button is clicked
        buttonLogin.setOnClickListener {

            val email = emailaddress.text.toString().trim()
            val password = clientpassword.text.toString().trim()

            if(email.isEmpty()){
                emailaddress.error = "Email required"
                emailaddress.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                clientpassword.error = "Password required"
                clientpassword.requestFocus()
                return@setOnClickListener
            }


            progressbarlogin.visibility = View.VISIBLE
            buttonLogin.visibility = View.GONE

            apiClient = RetrofitClient()
            sessionManager = SessionManager(this)

            apiClient.getApiService().userLogin( email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        // Error logging in
                        SweetAlertDialog(this@Login, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText(t.message)
                            .show()
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        val loginResponse = response.body()

                        if (loginResponse?.error == false && loginResponse.user != null) {
                            sessionManager.saveAuthToken(loginResponse.authToken)

                            val intent = Intent(applicationContext, MainActivity ::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(intent)
                            Toast.makeText(this@Login, "Login Succesful", Toast.LENGTH_SHORT).show()
                        } else {
                            // Error logging in
                            SweetAlertDialog(this@Login, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Login NOT Succesful")
                                .show()
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                            progressbarlogin.setVisibility(View.GONE)

                            buttonLogin.setVisibility(View.VISIBLE)
                        }
                    }
                })
        }

    }
}
