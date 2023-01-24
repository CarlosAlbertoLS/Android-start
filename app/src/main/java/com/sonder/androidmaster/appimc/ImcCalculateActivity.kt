package com.sonder.androidmaster.appimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sonder.androidmaster.R
import com.sonder.androidmaster.databinding.ActivityImcCalculateBinding
import java.text.DecimalFormat

class ImcCalculateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculateBinding
    private var isMaleSelected = true
    private var isFemaleSelected = false
    private var currentWeight: Int = 40
    private var currentAge: Int = 20
    private var currentHeigth: Int = 120
    companion object {
        const val IMC_KEY ="IMC_RESULT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initListeners() {
        binding.cardMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        binding.cardFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        binding.rsHeight.addOnChangeListener { _, value, _ ->
            val decimalFormat = DecimalFormat("#.##")
            currentHeigth = decimalFormat.format(value).toInt()
            binding.tvHeight.text = "$currentHeigth cm"
        }
        binding.btnPlus.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        binding.btnSubtraction.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        binding.btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        binding.btnSubtractionAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        binding.btnCalculate.setOnClickListener {
            val result = calculateIMC()
            goToResult(result)
        }
    }

    private fun goToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeigth.toDouble()/100 * currentHeigth.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        binding.tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        binding.tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        binding.cardMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        binding.cardFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
}