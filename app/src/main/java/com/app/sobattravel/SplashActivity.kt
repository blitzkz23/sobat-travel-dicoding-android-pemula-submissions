package com.app.sobattravel

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)

//		Declare and initialize layout widget
		val splashImage: ImageView = findViewById(R.id.as_iv_travel_illustration)
		val splashTitle: TextView = findViewById(R.id.as_tv_sobat_travel)
		val splashCopy: TextView = findViewById(R.id.as_tv_copyright)

//		Set alpha to zero for animation purpose
		splashImage.alpha = 0f
		splashTitle.alpha = 0f
		splashCopy.alpha = 0f
		splashTitle.animate().setDuration(3000).alpha(1f)
		splashCopy.animate().setDuration(3000).alpha(1f)
		splashImage.animate().setDuration(3000).alpha(1f).withEndAction {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
			finish()
		}

	}
}