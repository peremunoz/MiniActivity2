package com.example.miniactivity2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.miniactivity2.databinding.ActivityMainBinding

lateinit var startForResult : ActivityResultLauncher<Intent>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToByeScreen.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)

            if (binding.editTextNumber.text.isBlank() || binding.editTextNumber.text.isBlank()) {

                if (binding.editTextNumber.text.isEmpty()) {
                    binding.editTextNumber.error = "Please enter a number"
                }

                if (binding.editTextByeMessage.text.isEmpty()) {
                    binding.editTextByeMessage.error = "Please enter a message"
                }

            } else if (binding.editTextNumber.text.toString().toInt() <= 0) {
                binding.editTextNumber.error = "Please enter a number greater than 0"

            } else {

                val byeMessage = binding.editTextByeMessage.text.toString()
                val repetitions = binding.editTextNumber.text.toString().toInt()
                intent.putExtra("byeMessage", byeMessage)
                intent.putExtra("repetitions", repetitions)
                startForResult.launch(intent)

            }
        }

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val intent = result.data
                val byeMessage = intent?.getStringExtra("byeMessage")
                binding.saluteMessage.text = byeMessage

                binding.editTextNumber.text.clear()
                binding.editTextByeMessage.text.clear()
                binding.editTextByeMessage.requestFocus()
            }
        }
    }
}