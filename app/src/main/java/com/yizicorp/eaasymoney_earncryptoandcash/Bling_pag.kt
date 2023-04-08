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

class Bling_pag : AppCompatActivity() {
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bling_pag)

        ads()
        ads1()
        ads2()

        internet()

        val gohom = findViewById<TextView>(R.id.gohom)
        val blon = findViewById<Button>(R.id.bnudom)



        blon.setOnClickListener {
            val inu = Intent(android.content.Intent.ACTION_VIEW)
            inu.data = Uri.parse("https://www.blingfi.com/games")
            startActivity(inu)
        }

        gohom.setOnClickListener {

            val int = Intent(this,Homepage::class.java)
            startActivity(int)
            finishAffinity()
        }
    }

    private fun ads2() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewbling)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads1() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewblin)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewblings)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun internet() {
        val hhhh= findViewById<RelativeLayout>(R.id.tryagain)
        val button = findViewById<Button>(R.id.internet)


        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val active : NetworkInfo? = connectivityManager.activeNetworkInfo
        val cont : Boolean = active?.isConnectedOrConnecting == true

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