package dev.kibet.androidprojecttemplate.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.kibet.androidprojecttemplate.R
import dev.kibet.androidprojecttemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}