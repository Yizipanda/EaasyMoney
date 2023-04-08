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

class Game_mon_page : AppCompatActivity() {




    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mon_page)

        ads()
        ads1()

        val bbt = findViewById<TextView>(R.id.bb)
        val bbr = findViewById<Button>(R.id.bbre)
        val soli = findViewById<TextView>(R.id.solii)
        val silr = findViewById<Button>(R.id.solib)
        val mista = findViewById<TextView>(R.id.mist)
        val mista2 = findViewById<Button>(R.id.mistr)
        val biy = findViewById<TextView>(R.id.bitz)
        val buy = findViewById<Button>(R.id.bitzr)
        val cvb = findViewById<TextView>(R.id.scub)
        val cvbrr = findViewById<Button>(R.id.scubr)


        val nn = findViewById<TextView>(R.id.gohom)




        cvb.setOnClickListener {
            val int = Intent(this,Solitarecube::class.java)
            startActivity(int)

        }




        cvbrr.setOnClickListener {
            val int = Intent(this,Solitarecube::class.java)
            startActivity(int)
        }
        nn.setOnClickListener {

            val kk = Intent(this,Homepage::class.java)
            startActivity(kk)
            finish()
        }

        biy.setOnClickListener {
            val int = Intent(this,blitz21pag::class.java)
            startActivity(int)
        }

        buy.setOnClickListener {

            val int = Intent(this,blitz21pag::class.java)
            startActivity(int)
        }

        mista.setOnClickListener {
            val bv = Intent(this,Mistplaypage::class.java)
            startActivity(bv)
        }

        mista2.setOnClickListener {
            val bv = Intent(this,Mistplaypage::class.java)
            startActivity(bv)
        }


        soli.setOnClickListener {

            val inj = Intent(this,SolitareCash::class.java)
            startActivity(inj)
        }

        silr.setOnClickListener {
            val inh = Intent(this,SolitareCash::class.java)
            startActivity(inh)
        }

        bbr.setOnClickListener {
            val inj = Intent(this,Blackbingopag::class.java)
            startActivity(inj)
        }

        bbt.setOnClickListener {
            val inj = Intent(this,Blackbingopag::class.java)
            startActivity(inj)
        }


        internet()
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

        mAdView = findViewById(R.id.adViewgamon)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewmongam)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}