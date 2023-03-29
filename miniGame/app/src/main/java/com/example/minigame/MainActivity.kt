package com.example.minigame

import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.minigame.databinding.ActivityMainBinding
import com.google.android.material.color.utilities.Score
import org.w3c.dom.Text
import kotlin.concurrent.timer
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var checkButton: Button
    private lateinit var scoreTextView: TextView
    //자동으로 주입할 것들

    private val words = arrayOf("apple", "kiwi", "banana", "cherry")
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreTextView = findViewById(R.id.score)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            checkButton = findViewById(R.id.checkButton)
            checkButton.visibility = View.VISIBLE
            button.visibility = View.GONE
            startGame()
            //스타트버튼 누르면 시작
        }
    }

    private fun startGame() {
        quizSetting()
        checkButton.setOnClickListener {
            checkGame(textView.text.toString())
            //스타트버튼 누르면 시작
        }
    }

    private fun checkGame(word: String) {
        if (editText.text.toString() == word) {
            goodAnswer()
            check(score)
            startGame()
        } else {
            WrongAnswer()
        }
    }

    private fun goodAnswer(){
        editText.setHint("맞췄어요! 축하합니다")
        editText.text.clear()
        score++
        scoreTextView.visibility = View.VISIBLE
        scoreTextView.text = "score : $score"
    }
    private fun WrongAnswer(){
        editText.setHint("틀렸어요! 다시 입력해요!")
        editText.text.clear()
        score--
    }
    private fun check(score: Int){
        if(score == 5) {
            editText.setHint("게임에 승리하셨습니다!")
            scoreTextView.text = "승리!"
            button.text = "게임이 끝났습니다."
            Handler().postDelayed({ finish() }, 5000)
        }
    }

    private fun quizSetting(){
        var random = java.util.Random()
        //랜덤으로 값을 할당.
        var wordIndex = random.nextInt(words.size)
        //워드의 크기만큼 랜덤의 범위를 잡고 받음.
        var word = words[wordIndex]
        //그 숫자를 가져옴(1~4중에 하나를 워드에 넣음
        textView.text = word
    }
}


