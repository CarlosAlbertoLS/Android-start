package com.sonder.androidmaster.appimc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.sonder.androidmaster.R
import com.sonder.androidmaster.appimc.ImcCalculateActivity.Companion.IMC_KEY
import com.sonder.androidmaster.databinding.ActivityResultImcactivityBinding

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultImcactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        binding.btnRecalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        binding.tvImc.text = result.toString()
        when(result){
            in 0.00..18.50 -> {//Peso Bajo
                binding.tvResult.text = getString(R.string.title_bajo_peso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                binding.tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> {//Peso normal
                binding.tvResult.text = getString(R.string.title_peso_normal)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal))
                binding.tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> {//sobrepeso
                binding.tvResult.text = getString(R.string.title_sobrepeso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                binding.tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.99 -> {//obesidad
                binding.tvResult.text = getString(R.string.title_obesidad)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                binding.tvDescription.text = getString(R.string.description_obesidad)
            }
            else ->{//error
                binding.tvResult.text = getString(R.string.error)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                binding.tvImc.text = getString(R.string.error)
                binding.tvDescription.text = getString(R.string.error)
            }
        }
    }
}