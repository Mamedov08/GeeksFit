package com.example.geeksfit



import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.geeksfit.databinding.ActivitySplashBinding


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    private val SPLASH_DISPLAY_LENGTH = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transparentAppBar()
        setupPS()
        setupAnim()


    }

    private fun transparentAppBar() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun setupPS() {
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }

    private fun setupAnim() {
        val animImage = TranslateAnimation(
            0f,
            0f,
            0f,
            200f
        )
        animImage.duration = 1000
        animImage.fillAfter = true
        binding.splashImage.startAnimation(animImage)


        val animation = TranslateAnimation(
            0f,
            0f,
            0f,
            -200f
        )
        animation.duration = 1000
        animation.fillAfter = true
        binding.splashText.startAnimation(animation)
    }
}