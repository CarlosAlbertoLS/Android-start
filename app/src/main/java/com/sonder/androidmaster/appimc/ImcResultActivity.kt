package com.sonder.androidmaster.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.androidmaster.databinding.ActivityImcResultBinding

class ImcResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imc: Double = intent.extras?.getDouble("EXTRA_IMC") ?: -1.0

        binding.tvResultImc.text = when(imc){
            in 0.0..18.5 -> "Bajo de peso"
            in 18.6..24.9 -> "Normal"
            in 25.0..29.9 ->"Sobrepeso"
            in 30.0..99.0 -> "Obesidad"
            else ->"Error"
        }

    }
}