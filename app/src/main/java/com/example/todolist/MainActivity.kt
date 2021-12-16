package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController

import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.Todo
import java.util.Collections.list


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerViewss) as NavHostFragment
        navController = navHostFragment.navController
        // Set up the action bar for use with the NavController
       setupActionBarWithNavController(navController)





    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }












//
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragmentContainerViewss) as NavHostFragment
//        navController = navHostFragment.navController
//        setupActionBarWithNavController(navController)
//


    // this button for activate main for intent  :

//        val buotton3Name = findViewById<Button>(R.id.button_id)
//        buotton3Name.setOnClickListener {
//            intent = Intent (this, addActivity2 :: class.java)
//            startActivity(intent)
//
//
//        }

}