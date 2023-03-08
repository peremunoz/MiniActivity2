package com.example.miniactivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miniactivity2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}