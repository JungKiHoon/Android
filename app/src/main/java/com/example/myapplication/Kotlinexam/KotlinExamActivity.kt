package com.example.myapplication.Kotlinexam

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_kotlin_exam.*

class KotlinExamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_exam)

        // 데이터 타입을 설정해줄 필요 없다. 뒤에 세미콜론은 안붙여도 된다. val은 상수(자바의 final)
        val i = 10
        // var은 변수
        var a = 20
        a = 30

        my_button.setOnClickListener {
            Toast.makeText(this, "클릭!!", Toast.LENGTH_SHORT);
        }
    }
}