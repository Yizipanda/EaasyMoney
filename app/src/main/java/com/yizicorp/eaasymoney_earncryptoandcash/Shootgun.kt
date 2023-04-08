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

class Shootgun : AppCompatActivity() {

    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shootgun)

        internet()
        ads()
        ads1()



        val gohom = findViewById<TextView>(R.id.gohom)
        val shootdon = findViewById<Button>(R.id.shootdom)

        shootdon.setOnClickListener {

            val inh = Intent(android.content.Intent.ACTION_VIEW)

            inh.data = Uri.parse("https://play.google.com/store/apps/details?id=com.idosgames.shooterpvp&gl=US")
            startActivity(inh)

        }


        gohom.setOnClickListener {

            val inh = Intent(this,Homepage::class.java)
            startActivity(inh)
            finishAffinity()
        }
    }

    private fun ads1() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewsh)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewgu)
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