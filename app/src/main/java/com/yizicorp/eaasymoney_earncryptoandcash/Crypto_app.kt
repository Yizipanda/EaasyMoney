package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
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

class Crypto_app : AppCompatActivity() {

    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_app)



        val hom = findViewById<TextView>(R.id.gohom)
        val swet = findViewById<TextView>(R.id.sweat)
        val swet2 = findViewById<Button>(R.id.sweatre)
        val pi = findViewById<TextView>(R.id.Pi)
        val pi2 = findViewById<Button>(R.id.pidown)
        val bees1 = findViewById<TextView>(R.id.bee)
        val bees2 = findViewById<Button>(R.id.beere)
        val coinm = findViewById<TextView>(R.id.coin)
        val coinj = findViewById<Button>(R.id.coinre)
        val thut = findViewById<TextView>(R.id.tt)
        val thut2 = findViewById<Button>(R.id.ttre)



        internet()
        ads()
        ads1()


        thut.setOnClickListener {
            val inu = Intent(this,ThunderCore::class.java)
            startActivity(inu)
        }

        thut2.setOnClickListener {
            val inu = Intent(this,ThunderCore::class.java)
            startActivity(inu)
        }


        swet.setOnClickListener {

            val inj = Intent(this,Sweatcoinpage::class.java)
            startActivity(inj)
        }

        swet2.setOnClickListener {
            val inj = Intent(this,Sweatcoinpage::class.java)
            startActivity(inj)
        }

        pi.setOnClickListener {
            val ink = Intent(this,pinetworkpage::class.java)
            startActivity(ink)
        }

        pi2.setOnClickListener {

            val ink = Intent(this,pinetworkpage::class.java)
            startActivity(ink)
        }



        hom.setOnClickListener {

            val nin = Intent(this,Homepage::class.java)
            startActivity(nin)
            finishAffinity()
        }

        bees1.setOnClickListener {

            val int = Intent(this,BeeNetwork::class.java)
            startActivity(int)
        }

        bees2.setOnClickListener {
            val int = Intent(this,BeeNetwork::class.java)
            startActivity(int)
        }

        coinj.setOnClickListener {
            val int = Intent(this,COIN::class.java)
            startActivity(int)
        }

        coinm.setOnClickListener {
            val int = Intent(this,COIN::class.java)
            startActivity(int)
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

    private fun ads1() {

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewappcrypt)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewcrptapp)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}