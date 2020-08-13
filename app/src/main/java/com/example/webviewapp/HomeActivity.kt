package com.example.webviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.firebase.ui.auth.AuthUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        val appBarConfig = AppBarConfiguration(setOf(R.id.homeFragment,R.id.aboutUsFragment,R.id.contactUsFragment))
        setupActionBarWithNavController(navController,appBarConfig)

        bottomNavigationView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logOut->{
                AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener {
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this,"Log Out",Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        e->Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
                    }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}