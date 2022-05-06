package com.example.pagingretrofit.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.pagingretrofit.databinding.ActivityDetailBinding
import com.example.pagingretrofit.models.Character
import com.example.pagingretrofit.utils.Constants

class DetailActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_CHARACTER = "extra_character"

    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val character: Character? = intent.getParcelableExtra(EXTRA_CHARACTER)
        binding.apply {
            nameTextView.text = character!!.name
            speciesTextView.text = character!!.species
            genderTextView.text = character!!.gender
            statusTextView.text = character!!.status
            lastKnownLocationTextView.text = character!!.location.name
            numberOfEpisodesTextView.text = character!!.episode.size.toString()
            imageView.load(character!!.image) {
                crossfade(true)
                crossfade(1000)
            }

        }
    }
}