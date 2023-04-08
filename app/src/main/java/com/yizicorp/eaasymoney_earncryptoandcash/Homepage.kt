package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.ClipData
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.content.ServiceConnection
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.transition.Visibility
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.security.acl.Group
import android.content.ClipData.Item as Item1

class Homepage : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var users: Users
    lateinit var firestore: FirebaseFirestore
    lateinit var view: View
    lateinit var mAdView: AdView
    private var mInterstitialAd: InterstitialAd? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        ads()
        ads1()





        val pp = findViewById<Button>(R.id.privacypolicy)
        val discl = findViewById<Button>(R.id.discl)
        val trm = findViewById<Button>(R.id.tc)
        val ula = findViewById<Button>(R.id.ula)




        auth = FirebaseAuth.getInstance()

        val bv = auth.currentUser

        val hhh = auth.currentUser!!.uid

        firestore = FirebaseFirestore.getInstance()
        val hjhj = auth.currentUser!!.email.toString()


        val hh = FirebaseFirestore.getInstance()
      //  val username = findViewById<EditText>(R.id.username)
        val toog = findViewById<ImageButton>(R.id.hh)
        val menn = findViewById<DrawerLayout>(R.id.menues)
        val draw = findViewById<NavigationView>(R.id.sidf)
      //  val gttt= findViewById<TextView>(R.id.grtt)
      //  val nmnmn = findViewById<LinearLayout>(R.id.nvnv)
        val hhhh= findViewById<RelativeLayout>(R.id.tryagain)
        val button = findViewById<Button>(R.id.internet)
      //  val mony = findViewById<View>(R.id.money)
        val earn  = findViewById<View>(R.id.startearn)
        val contac = findViewById<Button>(R.id.contactus)



        contac.setOnClickListener {

            val mailint = Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto","yizicorp@gmail.com",null))

            startActivity(Intent.createChooser(mailint, "Send Email"))
        }

        pp.setOnClickListener {

            val int = Intent(android.content.Intent.ACTION_VIEW)
            int.data = Uri.parse("https://www.app-privacy-policy.com/live.php?token=B1WH5WSI1OGaHlQPZKVeQ6MduYSToitb")
            startActivity(int)
        }


        discl.setOnClickListener {
            val int = Intent(android.content.Intent.ACTION_VIEW)
            int.data = Uri.parse("https://www.app-privacy-policy.com/live.php?token=t7ve8xOAvo3obwzfj3dl7uLYOpYjrnqB")
            startActivity(int)
        }

        trm.setOnClickListener {
            val int = Intent(android.content.Intent.ACTION_VIEW)
            int.data = Uri.parse("https://www.app-privacy-policy.com/live.php?token=2gr4496BxK2HGa4mwfWl8VxGuytG1BP4\n" +
                    "\n")
            startActivity(int)
        }

        ula.setOnClickListener {
            val int = Intent(android.content.Intent.ACTION_VIEW)
            int.data = Uri.parse("https://www.app-privacy-policy.com/live.php?token=hb2TxjFUVY1GPtPi9fMCpJ6ANoZjrkuS")
            startActivity(int)
        }

        view = draw.getHeaderView(0)
        if (bv != null){
            val email =   view.findViewById<TextView>(R.id.grtt)

            email.setText(auth.currentUser!!.email)
        }


        internet()
       // gttt.text = "${auth.currentUser!!.email}"
















        draw.itemIconTintList = null




        draw.setNavigationItemSelectedListener {




            when (it.itemId) {


                R.id.complain -> {


                    val mailint = Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto","yizicorp@gmail.com",null))

                    startActivity(Intent.createChooser(mailint, "Send Email"))
                }


                R.id.sug -> {

                    val mailint = Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto","yizicorp@gmail.com",null))

                    startActivity(Intent.createChooser(mailint, "Send Email"))
                }

                R.id.ratapp -> {

                    val int = Intent(android.content.Intent.ACTION_VIEW)
                    int.data = Uri.parse("https://play.google.com/store/apps/details?id=com.yizicorp.eaasymoney_earncryptoandcash")
                    startActivity(int)

                }

                R.id.abb -> {

                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(this,"ca-app-pub-4579217632942142/5087655002", adRequest, object : InterstitialAdLoadCallback() {
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
                                val inr = Intent(this@Homepage, com.yizicorp.eaasymoney_earncryptoandcash.Aboutus::class.java)
                                startActivity(inr)
                            }

                            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                super.onAdFailedToShowFullScreenContent(p0)
                                Toast.makeText(this@Homepage,"Network Error",Toast.LENGTH_LONG).show()

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

                        val inr = Intent(this, com.yizicorp.eaasymoney_earncryptoandcash.Aboutus::class.java)
                        startActivity(inr)

                    }





                }

                    R.id.money -> {

                        var adRequest = AdRequest.Builder().build()

                        InterstitialAd.load(this,"ca-app-pub-4579217632942142/2461491666", adRequest, object : InterstitialAdLoadCallback() {
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
                                    val inr = Intent(this@Homepage, Money_app::class.java)
                                    startActivity(inr)
                                }

                                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                    super.onAdFailedToShowFullScreenContent(p0)
                                    Toast.makeText(this@Homepage,"Network Error",Toast.LENGTH_LONG).show()

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


                R.id.crypt -> {

                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(this,"ca-app-pub-4579217632942142/6713681578", adRequest, object : InterstitialAdLoadCallback() {
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
                                val inr = Intent(this@Homepage, Crypto_app::class.java)
                                startActivity(inr)

                            }

                            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                super.onAdFailedToShowFullScreenContent(p0)
                                Toast.makeText(this@Homepage,"Network Error",Toast.LENGTH_LONG).show()

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


                R.id.moneyg -> {



                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(this,"ca-app-pub-4579217632942142/3583001644", adRequest, object : InterstitialAdLoadCallback() {
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
                                val inr = Intent(this@Homepage, Game_mon_page::class.java)
                                startActivity(inr)

                            }

                            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                super.onAdFailedToShowFullScreenContent(p0)
                                Toast.makeText(this@Homepage,"Network Error",Toast.LENGTH_LONG).show()

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


                        val ing = Intent(this, Game_mon_page::class.java)
                        startActivity(ing)
                    }
                }

                R.id.cryptg -> {


                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(
                        this,
                        "ca-app-pub-4579217632942142/7985281083",
                        adRequest,
                        object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(adError: LoadAdError) {
                                mInterstitialAd = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                mInterstitialAd = interstitialAd
                            }
                        })


                    if (mInterstitialAd != null) {

                        mInterstitialAd?.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent()
                                    val inr = Intent(this@Homepage, Crypto_game::class.java)
                                    startActivity(inr)

                                }

                                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                    super.onAdFailedToShowFullScreenContent(p0)
                                    Toast.makeText(
                                        this@Homepage,
                                        "Network Error",
                                        Toast.LENGTH_LONG
                                    ).show()

                                }

                                override fun onAdImpression() {
                                    super.onAdImpression()
                                }

                                override fun onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent()
                                }


                            }

                        mInterstitialAd?.show(this)


                    } else {


                        val kii = Intent(this, Crypto_game::class.java)
                        startActivity(kii)
                    }
                }

             /*   R.id.moneyw -> {
                    val hj = Intent(this,web_mon::class.java)
                    startActivity(hj)
                }

                R.id.cryptw -> {

                    val gff = Intent(this,web_crypt::class.java)
                    startActivity(gff)
                } */



                R.id.signout -> {
                    auth.signOut()

                    val inty = Intent(this, MainActivity::class.java)
                    startActivity(inty)
                    finish()

                }

                R.id.air -> {


                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(
                        this,
                        "ca-app-pub-4579217632942142/9088563478",
                        adRequest,
                        object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(adError: LoadAdError) {
                                mInterstitialAd = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                mInterstitialAd = interstitialAd
                            }
                        })


                    if (mInterstitialAd != null) {

                        mInterstitialAd?.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent()
                                    val inr = Intent(this@Homepage, com.yizicorp.eaasymoney_earncryptoandcash.Airdrop_page::class.java)
                                    startActivity(inr)

                                }

                                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                    super.onAdFailedToShowFullScreenContent(p0)
                                    Toast.makeText(
                                        this@Homepage,
                                        "Network Error",
                                        Toast.LENGTH_LONG
                                    ).show()

                                }

                                override fun onAdImpression() {
                                    super.onAdImpression()
                                }

                                override fun onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent()
                                }


                            }

                        mInterstitialAd?.show(this)


                    } else {


                        val inj = Intent(this, com.yizicorp.eaasymoney_earncryptoandcash.Airdrop_page::class.java)
                        startActivity(inj)
                    }
                }


                R.id.nft -> {


                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(
                        this,
                        "ca-app-pub-4579217632942142/6462400133",
                        adRequest,
                        object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(adError: LoadAdError) {
                                mInterstitialAd = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                mInterstitialAd = interstitialAd
                            }
                        })


                    if (mInterstitialAd != null) {

                        mInterstitialAd?.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent()
                                    val inr = Intent(this@Homepage, com.yizicorp.eaasymoney_earncryptoandcash.Airdrop_page::class.java)
                                    startActivity(inr)

                                }

                                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                    super.onAdFailedToShowFullScreenContent(p0)
                                    Toast.makeText(
                                        this@Homepage,
                                        "Network Error",
                                        Toast.LENGTH_LONG
                                    ).show()

                                }

                                override fun onAdImpression() {
                                    super.onAdImpression()
                                }

                                override fun onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent()
                                }


                            }

                        mInterstitialAd?.show(this)


                    } else {

                        val ghg = Intent(this, NFT_page::class.java)
                        startActivity(ghg)
                    }

                }

            }
            true
        }


        toog.setOnClickListener {

            menn.openDrawer(GravityCompat.START)

        }

        earn.setOnClickListener {
            val inf = Intent(this,Start_earning_page::class.java)
            startActivity(inf)
        }


    }



    private fun ads1() {

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adViews)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    private fun ads() {

        MobileAds.initialize(this) {}

       mAdView = findViewById(R.id.adView)
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

                hhhh.visibility = GONE


            }else{

                hhhh.visibility = VISIBLE
            }



            button.setOnClickListener {
                val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activ : NetworkInfo? = connectivityManager.activeNetworkInfo
                val cont : Boolean = activ?.isConnectedOrConnecting == true

                if (cont){

                    hhhh.visibility = GONE


                }else{

                    Toast.makeText(this,"Try again later",Toast.LENGTH_LONG).show()

                    hhhh.visibility = VISIBLE
                }

            }
    }
}

