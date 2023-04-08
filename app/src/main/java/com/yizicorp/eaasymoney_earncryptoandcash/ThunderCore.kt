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

class ThunderCore : AppCompatActivity() {


    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thunder_core)

        internet()
        ads()


        val ttdonn = findViewById<Button>(R.id.ttdown)
        val hom = findViewById<TextView>(R.id.gohom)
        hom.setOnClickListener {
            val inh = Intent(this,Homepage::class.java)
            startActivity(inh)
            finishAffinity()
        }


        ttdonn.setOnClickListener {

            val srl = Intent(android.content.Intent.ACTION_VIEW)
            srl.data = Uri.parse("https://ttlink.site/aHR0cHM6Ly9taW5pbmcudGh1bmRlcmNvcmUuY29tLw==")
            startActivity(srl)
        }
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
            val connectivityManager =
                this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activ: NetworkInfo? = connectivityManager.activeNetworkInfo
            val cont: Boolean = activ?.isConnectedOrConnecting == true

            if (cont) {

                hhhh.visibility = View.GONE


            } else {

                Toast.makeText(this, "Try again later", Toast.LENGTH_LONG).show()

                hhhh.visibility = View.VISIBLE
            }
        }
    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewthun)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}