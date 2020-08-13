package com.example.webviewapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionProvider
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val tv_create_account = findViewById<TextView>(R.id.tv_create_account)
        tv_create_account.setOnClickListener(this)

        val btn_sigin = findViewById<Button>(R.id.btn_sigin)
        btn_sigin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_create_account->{
                val intentRegister = Intent(this,RegisterActivity::class.java)
                startActivity(intentRegister)
                finish()
            }
            R.id.btn_sigin->{
                if (validateSigninEmail() && validateSigninPassword()){
                    sigIn()
                    return
                }
            }
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null){
            startActivity(Intent(this,HomeActivity::class.java))
            Toast.makeText(baseContext, "Welcome", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun sigIn(){
        auth.signInWithEmailAndPassword(tinput_signin_email.editText!!.text.toString(), tinput_signin_password.editText!!.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Sign In failed.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

            }
    }

    fun validateSigninEmail() : Boolean{
        val signinEmailInput = tinput_signin_email.editText!!.text.toString().trim()
        if (signinEmailInput.isEmpty()){
            tinput_signin_email.error = "Field Cant be Empty"
            return false
        }else{
            tinput_signin_email.error = ""
            return true
        }
    }

    fun validateSigninPassword() : Boolean{
        val signinPasswordInput = tinput_signin_password.editText!!.text.toString().trim()
        if (signinPasswordInput.isEmpty()){
            tinput_signin_password.error = "Field Cant be Empty"
            return false
        }else{
            tinput_signin_password.error = ""
            return true
        }
    }


}