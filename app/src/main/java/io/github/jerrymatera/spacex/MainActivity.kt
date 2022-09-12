package io.github.jerrymatera.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.jerrymatera.spacex.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}