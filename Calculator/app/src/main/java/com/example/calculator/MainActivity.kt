package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.CollapsibleActionView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //이건 걍 불러오는거
    private lateinit var resultTextView: TextView
    //메인 숫자
    private var op = 0.0
    //표기될 위 숫자
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //오버라이드하고 외부 라이브러리 불러옴
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.result_text_view)
    }
    //넘버 클릭하면 위에 적어줌.
    fun onNumberClick(view: View){
        if(view is Button){
            var num: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }
            resultTextView.text = result + num
        }
    }
    fun onClearClick(view: View){
        if(view is Button){
            var num:String = "0"
            resultTextView.text="0"
            op = 0.0
            operator = ""
        }
    }
    //연산자를 누르면 숫자를 보이는 숫자를 초기화시키고 그 숫자를 미리 저장해둠.
    fun onOperatorClick(view: View){
        if(view is Button){
            operator = view.text.toString()
            op = resultTextView.text.toString().toDouble()
            resultTextView.text = "0"
            }
        }
    fun onEqualClick(view: View) {
        val operand2 : String = resultTextView.text.toString()
        val result: Double = calcResult(operand2)
        resultTextView.text = result.toString()
        op = result
        operator = ""
    }
    private fun calcResult(operand2: String): Double {
        return when (operator) {
            "+" -> op + operand2.toDouble()
            "-" -> op - operand2.toDouble()
            else -> 0.0
        }
    }
}