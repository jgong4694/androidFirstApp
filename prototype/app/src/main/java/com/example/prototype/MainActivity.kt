package com.example.prototype

import android.app.LauncherActivity.ListItem
import android.content.ClipData.Item
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Camera
import android.hardware.camera2.CameraManager
import android.nfc.NfcAdapter
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.appcompat.widget.ViewStubCompat
import androidx.core.view.get
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.fragment.findNavController
import com.example.prototype.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var intent: Intent
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var bottomNavi = findViewById<BottomNavigationView>(R.id.bottomicon)
        var menuItem = bottomNavi.menu

        var jeosuji = findViewById<ImageButton>(R.id.jeosu)
        jeosuji.setOnClickListener{
                intent = Intent(this, JeosujiActivity::class.java)
                startActivity(intent)
        }

        bottomNavi.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.noticeButton -> {
                    intent = Intent(this, NoticeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.myPageButton -> {
                    intent = Intent(this, MyPageActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.gisButton -> {
                    intent = Intent(this,GisActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.cameraButton -> {
                    intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
                    startActivity(intent)
                    false
                }
                else -> false
            }
        }
    }
}

