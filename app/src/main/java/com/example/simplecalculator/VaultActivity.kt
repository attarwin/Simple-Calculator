package com.example.simplecalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VaultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault)

        val tvTitle = findViewById<TextView>(R.id.tvVaultTitle)
        tvTitle.text = "Welcome to Secret Space\n(Apps & Clones Area)"
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        // Instantly wipe from Recents when Home button is pressed
        finishAndRemoveTask()
    }
}
