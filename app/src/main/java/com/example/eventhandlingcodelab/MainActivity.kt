package com.example.eventhandlingcodelab

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton = findViewById<Button>(R.id.clickButton)
        val longClickButton = findViewById<Button>(R.id.longClickButton)
        val statusText = findViewById<TextView>(R.id.statusText)
        val touchArea = findViewById<View>(R.id.touchArea)

        // High-level: Click
        clickButton.setOnClickListener {
            statusText.text = "Button clicked!"
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }

        // High-level: Long Click
        longClickButton.setOnLongClickListener {
            statusText.text = "Button long-pressed!"
            Toast.makeText(this, "Button long-pressed!", Toast.LENGTH_SHORT).show()
            true
        }

        // Low-level: Touch
        touchArea.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    statusText.text = "Touch started at: (${event.x.toInt()}, ${event.y.toInt()})"
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    statusText.text = "Moving at: (${event.x.toInt()}, ${event.y.toInt()})"
                    true
                }
                MotionEvent.ACTION_UP -> {
                    statusText.text = "Touch ended!"
                    true
                }
                else -> false
            }
        }
    }
}

