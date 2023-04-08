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

class Crypto_game : AppCompatActivity() {

    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_game)



        val axis = findViewById<TextView>(R.id.axiu)
        val axiz = findViewById<Button>(R.id.axre)
        val nn = findViewById<TextView>(R.id.gohom)
        val bling1 = findViewById<TextView>(R.id.bling)
        val bling2 = findViewById<Button>(R.id.blre)
        val cropp = findViewById<TextView>(R.id.cropb)
        val cropp2 = findViewById<Button>(R.id.cropb2)
        val thak = findViewById<TextView>(R.id.thata)
        val thak2 = findViewById<Button>(R.id.thattr)
        val shot1 = findViewById<TextView>(R.id.shot)
        val shot2 = findViewById<Button>(R.id.shottr)

        internet()
        ads()
        ads1()


        shot1.setOnClickListener {

            val inh = Intent(this,Shootgun::class.java)
            startActivity(inh)
        }

        shot2.setOnClickListener {
            val inh = Intent(this,Shootgun::class.java)
            startActivity(inh)
        }


        thak.setOnClickListener {

            val iny = Intent(this,ThetanArena::class.java)
            startActivity(iny)

        }

        thak2.setOnClickListener {
            val iny = Intent(this,ThetanArena::class.java)
            startActivity(iny)
        }


        cropp.setOnClickListener {
            val int = Intent(this,CropBytes::class.java)
            startActivity(int)
        }

        cropp2.setOnClickListener {

            val int = Intent(this,CropBytes::class.java)
            startActivity(int)
        }
        bling1.setOnClickListener {

            val int = Intent(this,Bling_pag::class.java)
            startActivity(int)

        }

        bling2.setOnClickListener {
            val int = Intent(this,Bling_pag::class.java)
            startActivity(int)

        }

        axiz.setOnClickListener {

            val ino = Intent(this, com.yizicorp.eaasymoney_earncryptoandcash.AxieInfinity::class.java)
            startActivity(ino)
        }

        axis.setOnClickListener {

            val int = Intent(this, com.yizicorp.eaasymoney_earncryptoandcash.AxieInfinity::class.java)
            startActivity(int)

        }


        nn.setOnClickListener {

            val kk = Intent(this,Homepage::class.java)
            startActivity(kk)
            finishAffinity()
        }
    }

    private fun ads1() {
        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adViewcrg)
        val adss = AdRequest.Builder().build()
        mAdView.loadAd(adss)
    }

    private fun ads() {
        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adViewgrc)
        val adss = AdRequest.Builder().build()
        mAdView.loadAd(adss)
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