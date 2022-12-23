package com.sonder.androidmaster.appimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.androidmaster.appsaludo.ResoultSaludoActivity
import com.sonder.androidmaster.databinding.ActivityImcCalculateBinding

class ImcCalculateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculateImc.setOnClickListener {
            val peso = binding.etWeight.text.toString().toDouble()
            val altura = binding.etHeight.text.toString().toDouble()/100
            val imc = getIMC(altura,peso)
            navigateToResult(imc)
        }
    }

    private fun getIMC(height:Double, weight:Double): Double{
        return weight/(height * height)
    }

    private fun navigateToResult(imc:Double){
        val intent = Intent(this, ImcResultActivity::class.java)
        intent.putExtra("EXTRA_IMC", imc)
        startActivity(intent)
    }
}