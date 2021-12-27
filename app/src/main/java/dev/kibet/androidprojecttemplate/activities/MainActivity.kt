package dev.kibet.androidprojecttemplate.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.kibet.androidprojecttemplate.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}