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
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class Start_earning_page : AppCompatActivity() {


    lateinit var mAdView: AdView
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_earning_page)


        val appmon = findViewById<Button>(R.id.butapp_money)
        val appcrypt = findViewById<Button>(R.id.butapp_crypto)
        val gamemon = findViewById<Button>(R.id.butgame_money)
        val gamecry = findViewById<Button>(R.id.butgame_crypto)
      //  val webmoi = findViewById<Button>(R.id.butwebsite_money)
       // val webcrt = findViewById<Button>(R.id.butwebsite_crypto)




        internet()
        ads()
        ads1()







        appmon.setOnClickListener {


            var adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                this,
                "ca-app-pub-4579217632942142/5811926772",
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                    }
                })

            if (mInterstitialAd != null){

                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        val inr = Intent(this@Start_earning_page, Money_app::class.java)
                        startActivity(inr)
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        Toast.makeText(this@Start_earning_page,"Network Error",Toast.LENGTH_LONG).show()

                    }

                    override fun onAdImpression() {
                        super.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                    }
                }

                    mInterstitialAd?.show(this)

            }else {

                val inr = Intent(this, Money_app::class.java)
                startActivity(inr)

            }
        }



        appcrypt.setOnClickListener {

            var adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                this,
                "ca-app-pub-4579217632942142/6569640529",
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                    }
                })


            if (mInterstitialAd != null){

             mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                 override fun onAdDismissedFullScreenContent() {
                     super.onAdDismissedFullScreenContent()
                     val inr = Intent(this@Start_earning_page, Crypto_app::class.java)
                     startActivity(inr)

                 }

                 override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                     super.onAdFailedToShowFullScreenContent(p0)
                     Toast.makeText(this@Start_earning_page,"Network Error",Toast.LENGTH_LONG).show()

                 }

                 override fun onAdImpression() {
                     super.onAdImpression()
                 }

                 override fun onAdShowedFullScreenContent() {
                     super.onAdShowedFullScreenContent()
                 }


             }

                mInterstitialAd?.show(this)



            }else {

                val inr = Intent(this, Crypto_app::class.java)
                startActivity(inr)

            }
        }

        gamemon.setOnClickListener {

            var adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                this,
                "ca-app-pub-4579217632942142/4115701723",
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                    }
                })

            if (mInterstitialAd != null){

                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        val ijk = Intent(this@Start_earning_page, Game_mon_page::class.java)
                        startActivity(ijk)

                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        Toast.makeText(this@Start_earning_page,"Network Error",Toast.LENGTH_LONG).show()

                    }

                    override fun onAdImpression() {
                        super.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                    }


                }

                mInterstitialAd?.show(this)



            }else {
                val ijk = Intent(this, Game_mon_page::class.java)
                startActivity(ijk)

            }
        }


        gamecry.setOnClickListener {

            var adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                this,
                "ca-app-pub-4579217632942142/2611048369",
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                    }
                })



            if (mInterstitialAd != null){

                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        val ijk = Intent(this@Start_earning_page, Crypto_game::class.java)
                        startActivity(ijk)

                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        Toast.makeText(this@Start_earning_page,"Network Error",Toast.LENGTH_LONG).show()
                        val ijk = Intent(this@Start_earning_page, Crypto_game::class.java)
                        startActivity(ijk)

                    }

                    override fun onAdImpression() {
                        super.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                    }


                }

                mInterstitialAd?.show(this)



            }else {
                val oko = Intent(this, Crypto_game::class.java)
                startActivity(oko)
            }
        }

        //webmoi.setOnClickListener {

          //  val jk = Intent(this,web_mon::class.java)
            //startActivity(jk)
        //}

        //webcrt.setOnClickListener {

          //  val hd = Intent(this,web_crypt::class.java)
            //startActivity(hd)
        //}
    }




    private fun ads1() {

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewst)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViewta)
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