package com.sonder.androidmaster

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.androidmaster.appimc.ImcCalculateActivity
import com.sonder.androidmaster.appimc.ImcResultActivity
import com.sonder.androidmaster.appsaludo.Saludo
import com.sonder.androidmaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaludo.setOnClickListener { goActivity(Saludo()) }
        binding.btnImc.setOnClickListener { goActivity(ImcCalculateActivity()) }
    }

    private fun goActivity(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}