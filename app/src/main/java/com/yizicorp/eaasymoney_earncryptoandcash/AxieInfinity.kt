package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class AxieInfinity : AppCompatActivity() {

    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.yizicorp.eaasymoney_earncryptoandcash.R.layout.activity_axie_infinity)

        ads()
        ads1()


        val gohom = findViewById<TextView>(com.yizicorp.eaasymoney_earncryptoandcash.R.id.gohom)
        val axirt = findViewById<Button>(com.yizicorp.eaasymoney_earncryptoandcash.R.id.axidom)


        gohom.setOnClickListener {
            val inj = Intent(this, com.yizicorp.eaasymoney_earncryptoandcash.Homepage::class.java)
            startActivity(inj)
            finishAffinity()
    }


        axirt.setOnClickListener {
            val inh = Intent(android.content.Intent.ACTION_VIEW)
            inh.data = Uri.parse("https://welcome.skymavis.com/download/")
            startActivity(inh)
        }
    }

    private fun ads1() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(com.yizicorp.eaasymoney_earncryptoandcash.R.id.adViewaxi)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(com.yizicorp.eaasymoney_earncryptoandcash.R.id.adViewinf)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

}