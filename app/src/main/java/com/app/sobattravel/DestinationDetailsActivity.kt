package com.app.sobattravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DestinationDetailsActivity : AppCompatActivity() {
//	Declare late variable globally
	private lateinit var ivDestination: ImageView
	private lateinit var tvDestination: TextView
	private lateinit var tvLocation: TextView
	private lateinit var tvRating: TextView
	private lateinit var tvDetail: TextView
	private lateinit var tvPrice: TextView
	private lateinit var btnTicket: Button
	private lateinit var btnShare: Button

	companion object {
//		Variable to receive intent's data from main activity.
		const val DESTINATION_NAME = "destination_name"
		const val DESTINATION_LOCATION = "destination_location"
		const val DESTINATION_RATING = "destination_rating"
		const val DESTINATION_DETAIL = "destination_detail"
		const val DESTINATION_IMAGE = "destination_image"
		const val DESTINATION_PRICE = "destination_price"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destination_details)

//		Initialize the late variable
		ivDestination = findViewById(R.id.add_iv_photo)
		tvDestination = findViewById(R.id.add_tv_destination)
		tvLocation = findViewById(R.id.add_tv_location)
		tvRating = findViewById(R.id.add_tv_destination_rating)
		tvDetail = findViewById(R.id.add_tv_details)
		tvPrice = findViewById(R.id.add_tv_prices)
		btnTicket = findViewById(R.id.add_bt_ticket)
		btnShare = findViewById(R.id.add_bt_share)

//		Get the Extra of intent from the main activity
		val image = intent.getIntExtra(DESTINATION_IMAGE, 0)
		val destination = intent.getStringExtra(DESTINATION_NAME)
		val location = intent.getStringExtra(DESTINATION_LOCATION)
		val rating = intent.getDoubleExtra(DESTINATION_RATING, 0.0)
		val detail = intent.getStringExtra(DESTINATION_DETAIL)
		val price = intent.getIntExtra(DESTINATION_PRICE, 0)

//		This title will set the support action bat name to the name of the clicked destination
		title = "$destination"

//		Set the dummy text on the original view to the data from the database
		ivDestination.setImageResource(image)
		tvDestination.text = destination
		tvLocation.text = location
		tvRating.text = rating.toString()
		tvDetail.text = detail
		tvPrice.text = price.toString()

//		Get string of the application name to use in onclick listener.
		val appName = getString(R.string.app_name)

		btnTicket.setOnClickListener { Toast.makeText(this, "Anda telah menambahkan item ini ke cart(not yet implemented).", Toast.LENGTH_SHORT).show() }
		btnShare.setOnClickListener {
//			An implicit intent to share a content.
			val sendIntent: Intent = Intent().apply {
				action = Intent.ACTION_SEND
				putExtra(Intent.EXTRA_TEXT, "Ayuk jalan-jalan ke $destination, buka di aplikasi $appName sekarang!")
				type = "text/plain"
			}
			val shareIntent = Intent.createChooser(sendIntent, null)
			startActivity(shareIntent)
		}

	}
}