package com.example.miniactivity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miniactivity2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val byeMessage = intent.getStringExtra("byeMessage")
        val repetitions = intent.getIntExtra("repetitions", 0)

        binding.byeText.text = byeMessage?.repeat(repetitions)

        binding.backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("byeMessage", binding.byeText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}