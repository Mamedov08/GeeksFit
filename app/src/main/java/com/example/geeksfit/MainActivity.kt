package com.example.geeksfit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.geeksfit.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_activity_main)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.registerFragment || destination.id == R.id.loginFragment || destination.id == R.id.registrationFragment || destination.id == R.id.newPasswordFragment || destination.id == R.id.forgotPasswordFragment || destination.id == R.id.succesPasswordFragment || destination.id == R.id.verificationFragment) {
                navView.visibility = View.GONE
            } else {
                navView.visibility = View.VISIBLE
            }
            if (destination.id == R.id.loginFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
        navView.setupWithNavController(navController)
    }
}


