package com.example.prototype

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.view.SurfaceView
import android.view.TextureView
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.prototype.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class GisActivity : AppCompatActivity() {
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gis_main)


        var back = findViewById<ImageButton>(R.id.BackMain)
        back.setOnClickListener{
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right)
        }
        var click = findViewById<ImageButton>(R.id.mySiteButton)
        click.setOnClickListener {
            intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
            false
        }
        var detailClick = findViewById<LinearLayout>(R.id.detailText)
        detailClick.setOnClickListener {
            intent = Intent(this,JeosujiActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

        var bottomNavi = findViewById<BottomNavigationView>(R.id.bottomicon)
        bottomNavi.menu.findItem(R.id.gisButton).setChecked(true)

        bottomNavi.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.noticeButton -> {
                    intent = Intent(this, NoticeActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    true
                }
                R.id.homeButton -> {
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    true
                }
                R.id.myPageButton -> {
                    intent = Intent(this,MyPageActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    true
                }
                R.id.cameraButton -> {
                    intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    false
                }
                else -> false
            }
        }
    }
}
