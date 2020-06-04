package com.sourceit.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            button.isClickable = false
            timer_time.isEnabled = false
            val timerTimeInMillis = timer_time.text?.ifEmpty { "0" }.toString().toLong() * 1000
            val timer = object : CountDownTimer(timerTimeInMillis, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    textView.text = String.format("%d", millisUntilFinished / 1000)
                }

                override fun onFinish() {
                    textView.text = " - "
                    button.isClickable = true
                    timer_time.isEnabled = true
                }
            }.start()
        }
    }
}
