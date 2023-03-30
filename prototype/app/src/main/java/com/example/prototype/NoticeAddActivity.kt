package com.example.prototype

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class NoticeAddActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var likeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.noticeadd)


        var back = findViewById<ImageButton>(R.id.BackMain)
        back.setOnClickListener{
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

        var bottomNavi = findViewById<BottomNavigationView>(R.id.bottomicon)
        bottomNavi.menu.findItem(R.id.noticeButton).setChecked(true)

        bottomNavi.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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
                R.id.gisButton -> {
                    intent = Intent(this,GisActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    true
                }
                else -> false
            }
        }
    }
}