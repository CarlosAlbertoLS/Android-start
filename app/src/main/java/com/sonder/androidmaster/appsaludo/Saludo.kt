package com.sonder.androidmaster.appsaludo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sonder.androidmaster.R
import com.sonder.androidmaster.databinding.ActivitySaludoBinding

class Saludo : AppCompatActivity() {
    private lateinit var binding: ActivitySaludoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySaludoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnName.setOnClickListener {
            val name = binding.etName.text.toString()
            if(name.isNotEmpty()) {
                val intent = Intent(this, ResoultSaludoActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
    }
}