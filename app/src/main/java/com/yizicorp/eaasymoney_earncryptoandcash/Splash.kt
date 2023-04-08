package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({



            val int = Intent(this,MainActivity::class.java)
            startActivity(int)
            finish()
        },5000)
    }
}