package com.yizicorp.eaasymoney_earncryptoandcash

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
         db = FirebaseFirestore.getInstance()


        val username = findViewById<EditText>(R.id.username)
        val email4 = findViewById<EditText>(R.id.mas)
        val password23 = findViewById<EditText>(R.id.pad)
        val signip0 = findViewById<Button>(R.id.signup2)



        signip0.setOnClickListener {


            val user = username.text.toString().trim()
            val email9 = email4.text.toString().trim()
            val password2 = password23.text.toString().trim()
          //  val uid = auth.currentUser!!.uid



            if (user.isEmpty() || email9.isEmpty() || password2.isEmpty()) {

                if (user.isEmpty()) {
                    username.error = "ENTER YOUR USERNAME"
                }

                if (email9.isEmpty()) {
                    email4.error = "Input your e-mail"
                }
                if (password2.isEmpty()) {
                    password23.error = " Input your password"
                }
            } else



                auth.createUserWithEmailAndPassword(email9, password2).addOnCompleteListener {





                    if (it.isSuccessful) {


                        val inte = Intent(this, MainActivity::class.java)
                        startActivity(inte)
                        finish()



                        val Users = hashMapOf(

                            "Username" to user,
                            "Email" to email9,
                            "uid" to auth.currentUser!!.uid

                        )
                        db.collection("Users")
                            .add(Users)
                            .addOnCompleteListener {  }







                    }
                }.addOnFailureListener {

                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                }

        }
    }

        /*   private fun info(user: String, email9: String,uid : String,) {


        val info = FirebaseFirestore.getInstance()


        val Users: MutableMap<String, Any> = HashMap()

        Users["Username"] = user
        Users["Email"] = email9
        Users["uid"] = auth.currentUser!!.uid

        info.collection("Users")
            .add(Users)
            .addOnCompleteListener {

            }


    } */
    }

