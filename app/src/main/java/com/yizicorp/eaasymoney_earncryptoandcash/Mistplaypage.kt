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

class Mistplaypage : AppCompatActivity() {

    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mistplaypage)

        internet()
        ads()
        ads1()


        val mistdon = findViewById<Button>(R.id.mistdom)
        val hom = findViewById<TextView>(R.id.gohom)



        hom.setOnClickListener {
            val ink = Intent(this,Homepage::class.java)
            startActivity(ink)
            finishAffinity()
        }

        mistdon.setOnClickListener {

            val bnu = Intent(android.content.Intent.ACTION_VIEW)
            bnu.data = Uri.parse("https://play.google.com/store/apps/details?id=com.mistplay.mistplay&gl=US")
            startActivity(bnu)
        }
    }

    private fun ads1() {

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewmis)
        val adss = AdRequest.Builder().build()
        mAdView.loadAd(adss)
    }

    private fun ads() {
        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adViewmist)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    private fun internet() {
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