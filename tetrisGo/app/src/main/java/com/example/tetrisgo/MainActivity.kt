package com.example.tetrisgo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.tetrisgo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

}