package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class forgetpassreset : AppCompatActivity() {


    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpassreset)


        handler = Handler()

        handler.postDelayed({


            val intp = Intent(this,MainActivity::class.java)
            startActivity(intp)
            finish()

        },5000)
    }
}