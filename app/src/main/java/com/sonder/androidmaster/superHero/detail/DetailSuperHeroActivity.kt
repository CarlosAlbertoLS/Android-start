package com.sonder.androidmaster.superHero.detail

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sonder.androidmaster.databinding.ActivityDetailSuperHeroBinding
import com.sonder.androidmaster.superHero.ApiService
import com.sonder.androidmaster.superHero.data.PowerStatsResponse
import com.sonder.androidmaster.superHero.data.SuperheroDetailResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperHeroActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding: ActivityDetailSuperHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)
        initListeners()
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener { onBackPressed() }
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)
            if (superheroDetail.body() != null){
                runOnUiThread {
                    createUI(superheroDetail.body()!!)
                }
            }
        }
    }

    private fun createUI(superhero: SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superhero.name
        binding.tvRealName.text = superhero.biography.realName
        binding.tvPublisher.text = superhero.biography.publisher
        prepareStats(superhero.powerstats)
        binding.numberIntelligence.text = superhero.powerstats.intelligence
        binding.numberStrength.text = superhero.powerstats.strength
        binding.numberCombat.text = superhero.powerstats.combat
        binding.numberPower.text = superhero.powerstats.power
        binding.numberSpeed.text = superhero.powerstats.speed
        binding.numberDurability.text = superhero.powerstats.durability
        binding.tvHeight.text = "Altura: ${superhero.appearance.altura.last()}"
        binding.tvWeight.text = "Peso: ${superhero.appearance.peso.last()}"
        binding.tvOccupation.text = "Ocupación: ${superhero.work.occupation}"
        binding.tvBase.text = "Base: ${superhero.work.base}"
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewStrength, powerstats.strength)
    }

    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = piexelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun piexelToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}