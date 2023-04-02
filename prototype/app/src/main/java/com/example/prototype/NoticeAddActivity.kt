package com.example.prototype

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.File

class NoticeAddActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var likeButton: Button
    private lateinit var imageFile: File
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                imageFile = File(uploadImage(uri))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.noticeadd)

        var back = findViewById<ImageButton>(R.id.BackMain)
        back?.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        var bottomNavi = findViewById<BottomNavigationView>(R.id.bottomicon)
        bottomNavi.menu.findItem(R.id.noticeButton).isChecked = true

        bottomNavi.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeButton -> {
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    true
                }
                R.id.myPageButton -> {
                    intent = Intent(this, MyPageActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    true
                }
                R.id.cameraButton -> {
                    intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    false
                }
                R.id.gisButton -> {
                    intent = Intent(this, GisActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    true
                }
                else -> false
            }
        }
        var upload = findViewById<Button>(R.id.upload)
        upload.setOnClickListener {
            intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            getContent.launch(intent.toString())
        }
    }

    private fun uploadImage(uri: Uri?): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri!!, projection, null, null, null)
        val columnIndex = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor?.moveToFirst()
        val path = cursor?.getString(columnIndex ?: 0)
        cursor?.close()
        return path ?: ""
    }
}