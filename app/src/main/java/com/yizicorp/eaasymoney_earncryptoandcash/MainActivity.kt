package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var datatbase: FirebaseDatabase
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mail0 = findViewById<EditText>(R.id.mail)
        val pass2 = findViewById<EditText>(R.id.pass)
        val signup = findViewById<Button>(R.id.signup)
        val fgg = findViewById<Button>(R.id.forgot)
        val logh = findViewById<Button>(R.id.login)
        val load = findViewById<ProgressBar>(R.id.load)




        auth = FirebaseAuth.getInstance()

        val user1 = auth.currentUser


       if (user1 != null) {

            val int7 = Intent(this, Homepage::class.java)
            startActivity(int7)
            finish()
        }

        logh.setOnClickListener {

            load.visibility = View.VISIBLE



            val mail9 = mail0.text.toString().trim()
            val pass21 = pass2.text.toString().trim()



            if (mail9.isEmpty() || pass21.isEmpty()) {
                load.visibility = View.INVISIBLE

                if (mail9.isEmpty()) {
                    mail0.error = "Input your email"
                }
                if (pass21.isEmpty()) {
                    pass2.error = "Enter your Password"
                }
            } else
                auth.signInWithEmailAndPassword(mail9, pass21).addOnCompleteListener {



                    if (it.isSuccessful) {

                        load.visibility = View.INVISIBLE






                        val cur = Intent(this, Homepage::class.java)
                        startActivity(cur)
                        finish()

                        load.visibility= View.INVISIBLE

                    }
                }.addOnFailureListener {


                    load.visibility= View.INVISIBLE


                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }


        }



        signup.setOnClickListener {

            val kk = Intent(this, SignUp::class.java)
            startActivity(kk)
        }

        fgg.setOnClickListener {

            val sdd = Intent(this, Forgetpass::class.java)
            startActivity(sdd)

        }


    }


}