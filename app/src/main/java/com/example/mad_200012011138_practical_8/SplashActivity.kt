package com.example.mad_200012011138_practical_8

import android.content.Intent
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener{

    lateinit var logo_img : ImageView
    lateinit var logoframebyframeanimation : AnimationDrawable
    lateinit var twinanimation : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logo_img = findViewById(R.id.img_view)
        logo_img.setBackgroundResource(R.drawable.uvpce_logo_list)
        logoframebyframeanimation = logo_img.background as  AnimationDrawable
        twinanimation = AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        twinanimation.setAnimationListener(this)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            logoframebyframeanimation.start()
            logo_img.startAnimation(twinanimation)
        }
        else{
            logoframebyframeanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also {
            overridePendingTransition(R.anim.scale_in,R.anim.scale_out)
            startActivity(it)
            finish()
        }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}