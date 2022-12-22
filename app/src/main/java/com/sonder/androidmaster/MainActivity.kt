package com.sonder.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.androidmaster.appsaludo.Saludo
import com.sonder.androidmaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaludo.setOnClickListener {
            val intent = Intent(this, Saludo::class.java)
            startActivity( intent )
        }
    }
}