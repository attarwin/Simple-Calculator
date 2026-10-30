package com.example.simplecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentInput = ""
    private val SECRET_PIN = "1234" // Default Passcode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener { btn ->
                currentInput += (btn as Button).text
                tvDisplay.text = currentInput
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            tvDisplay.text = "0"
        }

        // Secret Trigger via Equal Button (=)
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            if (currentInput == SECRET_PIN) {
                Toast.makeText(this, "Vault Unlocked!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, VaultActivity::class.java)
                startActivity(intent)
                currentInput = ""
                tvDisplay.text = "0"
            } else {
                // Perform basic math or clear for regular calculator feel
                Toast.makeText(this, "Calculation Output", Toast.LENGTH_SHORT).show()
                currentInput = ""
                tvDisplay.text = "0"
            }
        }
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        // Auto-close / hide when Home Button is pressed
        finishAndRemoveTask()
    }
}
