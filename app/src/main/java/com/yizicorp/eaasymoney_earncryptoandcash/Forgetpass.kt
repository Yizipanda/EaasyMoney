package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Forgetpass : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpass)
    }

    fun pll(view: View) {



        val spac = findViewById<EditText>(R.id.mail9)

         val spac3 = spac.text.toString().trim()

        if (spac3.isEmpty()){
            spac.error = "Input your Email"
        }else{


            FirebaseAuth.getInstance().sendPasswordResetEmail(spac3).addOnCompleteListener {

                if (it.isSuccessful){


                    val inty = Intent(this,forgetpassreset::class.java)
                    startActivity(inty)
                    finish()


                }else{

                    Toast.makeText(this,"E-mail isn't registered",Toast.LENGTH_LONG).show()

                    val int = Intent(this,SignUp::class.java)
                    startActivity(int)

                }

            }.addOnFailureListener {

                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }

    }
}