package com.anirban.activecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    lateinit var btnLogIn: Button

    val validMobileNumber = "9382217301"
    val validPassword = arrayOf("tony","steve","thor","bruce","tchalla","natasha","thanos")

    lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_login)

        if (isLoggedIn){
            val intent = Intent(this@LoginActivity,AvengerActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log in"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogIn = findViewById(R.id.btnLogIn)

        btnLogIn.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString();
            val password = etPassword.text.toString();
            var nameOfAvenger = "Avenger"
            val intent = Intent(this@LoginActivity, AvengerActivity::class.java)
            if (mobileNumber == validMobileNumber) {
                when (password) {
                    validPassword[0] -> {
                        nameOfAvenger = "Iron Man"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validPassword[1] -> {
                        nameOfAvenger = "Captain America"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validPassword[2] -> {
                        nameOfAvenger = "Thor"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validPassword[3] -> {
                        nameOfAvenger = "Hulk"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validPassword[4] -> {
                        nameOfAvenger = "Black Panther"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validPassword[5] -> {
                        nameOfAvenger = "Black Widow"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validPassword[6] -> {
                        nameOfAvenger = "The Avengers"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }


                    else -> {
                        Toast.makeText(
                            this@LoginActivity, "Incorrect Password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
                    else {
                    Toast.makeText(
                        this@LoginActivity, "Incorrect Credentials",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }

        txtForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

                override fun onPause() {
                    super.onPause()
                    finish()
                }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
            }
