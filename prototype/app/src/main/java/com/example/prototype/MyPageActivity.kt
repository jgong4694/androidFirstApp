package com.example.prototype

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.nio.file.Files

class MyPageActivity : AppCompatActivity() {
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_page)

        var mainLayout = findViewById<LinearLayout>(R.id.mainLayout)
        var buttonCode1 = findViewById<ImageButton>(R.id.code1)
        var buttonCode2 = findViewById<ImageButton>(R.id.code2)

        var codeSelect1 = findViewById<LinearLayout>(R.id.couponCode1)
        var codeSelect2 = findViewById<LinearLayout>(R.id.couponCode2)

        codeSelect1.setOnClickListener{
            if(buttonCode2.isVisible){
                buttonCode2.isVisible = !buttonCode2.isVisible
            }
            buttonCode1.isVisible = !buttonCode1.isVisible
        }
        codeSelect2.setOnClickListener{
            if(buttonCode1.isVisible){
                buttonCode1.isVisible = !buttonCode1.isVisible
            }
            buttonCode2.isVisible = !buttonCode2.isVisible
        }


        var buttonSwap1 = findViewById<Button>(R.id.coupon_button)
        var buttonSwap2 = findViewById<Button>(R.id.gesi_button)
        var couponNotice = findViewById<LinearLayout>(R.id.coupon_main)
        var gesiNotice = findViewById<LinearLayout>(R.id.gesi)
        buttonSwap1.setOnClickListener {
            buttonSwap2.setTextColor(getColor(android.R.color.black))
            buttonSwap2.setBackgroundColor(getColor(android.R.color.white))
            buttonSwap1.setTextColor(getColor(android.R.color.white))
            buttonSwap1.setBackgroundColor(getColor(android.R.color.black))
            couponNotice.isVisible = true
            gesiNotice.isGone = true
        }
        buttonSwap2.setOnClickListener {

            buttonSwap1.setTextColor(getColor(android.R.color.black))
            buttonSwap1.setBackgroundColor(getColor(android.R.color.white))
            buttonSwap2.setTextColor(getColor(android.R.color.white))
            buttonSwap2.setBackgroundColor(getColor(android.R.color.black))
            couponNotice.isGone = true
            gesiNotice.isVisible = true
        }

        var back = findViewById<ImageButton>(R.id.BackMain)
        back.setOnClickListener(View.OnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        var bottomNavi = findViewById<BottomNavigationView>(R.id.bottomicon)
        bottomNavi.menu.findItem(R.id.myPageButton).setChecked(true)

        bottomNavi.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.noticeButton -> {
                    intent = Intent(this, NoticeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.homeButton -> {
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.gisButton -> {
                    intent = Intent(this, GisActivity::class.java)
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