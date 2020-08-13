package com.example.webviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val tv_signin= findViewById<TextView>(R.id.tv_signin)
        tv_signin.setOnClickListener(this)

        val btn_register = findViewById<Button>(R.id.btn_register)
        btn_register.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_signin->{
                val intentMain = Intent(this,MainActivity::class.java)
                startActivity(intentMain)
            }
            R.id.btn_register->{
                if (validateUsername() && validateRegisterEmail() && validateRegisterPassword()){
                    register()
                    return
                }
            }
        }
    }

    private fun register(){
        auth.createUserWithEmailAndPassword(tinput_register_email.editText!!.text.toString(), tinput_register_password.editText!!.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Registered Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun validateUsername() : Boolean{
        val usernameInput = tinput_register_name.editText!!.text.toString().trim()
        if (usernameInput.isEmpty()){
            tinput_register_name.error = "Field Cant be Empty"
            return false
        }else if (usernameInput.length > 10){
            tinput_register_name.error = "Username too Long"
            return false
        }else{
            tinput_register_name.error = ""
            return true
        }
    }

    fun validateRegisterEmail() : Boolean{
        val registerEmailInput = tinput_register_email.editText!!.text.toString().trim()
        if (registerEmailInput.isEmpty()){
            tinput_register_email.error = "Field Cant be Empty"
            return false
        }else{
            tinput_register_email.error = ""
            return true
        }
    }

    fun validateRegisterPassword() : Boolean{
        val registerPasswordInput = tinput_register_password.editText!!.text.toString().trim()
        if (registerPasswordInput.isEmpty()){
            tinput_register_password.error = "Field Cant be Empty"
            return false
        }else{
            tinput_register_password.error = ""
            return true
        }
    }
}