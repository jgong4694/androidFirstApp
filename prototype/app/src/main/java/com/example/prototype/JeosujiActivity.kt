package com.example.prototype

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class JeosujiActivity : AppCompatActivity() {
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jeosugi)

        var back = findViewById<ImageButton>(R.id.BackMain)
        back.setOnClickListener(View.OnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right)
        })
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
                R.id.homeButton -> {
                    intent = Intent(this,MyPageActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    true
                }
                else -> false
            }
        }
    }
}
