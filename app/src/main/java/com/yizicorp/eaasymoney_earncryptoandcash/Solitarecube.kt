package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Solitarecube : AppCompatActivity() {

    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solitarecube)

        val nn = findViewById<TextView>(R.id.gohom)
        val mju = findViewById<Button>(R.id.solikdom)

        ads()
        ads1()

        intyt()



        nn.setOnClickListener {

            val kk = Intent(this,Homepage::class.java)
            startActivity(kk)
            finishAffinity()
        }


        mju.setOnClickListener {

            val fgh = Intent(android.content.Intent.ACTION_VIEW)
            fgh.data = Uri.parse("https://games.skillz.com/games/solitaire/solitaire-cube-1801")
            startActivity(fgh)
        }





    }

    private fun ads1() {
        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adViewsolit)
        val adss = AdRequest.Builder().build()
        mAdView.loadAd(adss)
    }

    private fun ads() {

        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adViewcub)
        val adss = AdRequest.Builder().build()
        mAdView.loadAd(adss)
    }

    private fun intyt() {
        val hhhh= findViewById<RelativeLayout>(R.id.tryagain)
        val button = findViewById<Button>(R.id.internet)






        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activ : NetworkInfo? = connectivityManager.activeNetworkInfo
        val cont : Boolean = activ?.isConnectedOrConnecting == true

        if (cont){

            hhhh.visibility = View.GONE


        }else{

            hhhh.visibility = View.VISIBLE
        }



        button.setOnClickListener {
            val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activ : NetworkInfo? = connectivityManager.activeNetworkInfo
            val cont : Boolean = activ?.isConnectedOrConnecting == true

            if (cont){

                hhhh.visibility = View.GONE


            }else{

                Toast.makeText(this,"Try again later", Toast.LENGTH_LONG).show()

                hhhh.visibility = View.VISIBLE
            }

        }
    }
}