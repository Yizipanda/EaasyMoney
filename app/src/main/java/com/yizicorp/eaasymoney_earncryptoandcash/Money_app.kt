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
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class Money_app : AppCompatActivity() {

    lateinit var mAdView: AdView

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_app)


        ads()
        ads1()

        firebaseAnalytics = Firebase.analytics

        val hom = findViewById<TextView>(R.id.gohom)
        val hon = findViewById<TextView>(R.id.honey)
        val hon2 = findViewById<Button>(R.id.honey1)
        val fiel = findViewById<TextView>(R.id.fielda)
        val fiel2 = findViewById<Button>(R.id.fieldra)
        val fap = findViewById<TextView>(R.id.fop)
        val fapdon = findViewById<Button>(R.id.fopra)
        val swagb =findViewById<TextView>(R.id.swag)
        val swagrt = findViewById<Button>(R.id.swagra)
        val gooj = findViewById<TextView>(R.id.goog)
        val gppi = findViewById<Button>(R.id.googra)

    internet()

        gooj.setOnClickListener {

            val ing = Intent(this,Googlepage::class.java)
            startActivity(ing)
        }

        gppi.setOnClickListener {

            val ing =Intent(this,Googlepage::class.java)
            startActivity(ing)
        }

        swagb.setOnClickListener {

            val ink = Intent(this,Swagbuckspage::class.java)
            startActivity(ink)

        }

        swagrt.setOnClickListener {
            val ink = Intent(this,Swagbuckspage::class.java)
            startActivity(ink)
        }

        fap.setOnClickListener {

            val iny = Intent(this,Foappage::class.java)
            startActivity(iny)
        }

        fapdon.setOnClickListener {
            val iny = Intent(this,Foappage::class.java)
            startActivity(iny)
        }


        hom.setOnClickListener {

            val nin = Intent(this,Homepage::class.java)
            startActivity(nin)
            finishAffinity()
        }

        hon.setOnClickListener {
            val intt = Intent(this,Honeygainpage::class.java)
            startActivity(intt)
        }
        hon2.setOnClickListener {
            val intt = Intent(this,Honeygainpage::class.java)
            startActivity(intt)
        }

        fiel.setOnClickListener {

            val int = Intent(this,FieldAgentPage::class.java)
            startActivity(int)
        }
        fiel2.setOnClickListener {
            val int = Intent(this,FieldAgentPage::class.java)
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

        mAdView = findViewById(R.id.adViewmonapp)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewapmon)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

}
