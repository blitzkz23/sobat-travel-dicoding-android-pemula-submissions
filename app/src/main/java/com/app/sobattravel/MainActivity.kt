package com.app.sobattravel

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
	private lateinit var username: TextView
	private lateinit var headingText: TextView
	private lateinit var rvDestinations: RecyclerView
	private lateinit var userImage: CircleImageView
	private var list: ArrayList<Destination> = arrayListOf()
	private var title: String = "Sobat Travel"


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

//		Declare and initialize view
		username = findViewById(R.id.am_tv_username)
		headingText = findViewById(R.id.am_tv_heading)
		rvDestinations = findViewById(R.id.am_rv_destination)
		rvDestinations.setHasFixedSize(true)
		userImage = findViewById(R.id.am_iv_user_image)

		userImage.setOnClickListener { navigateToAboutActivity() }

//		getColor need min apk of 23
		val orange = getColor(R.color.main_orange)

//		To change textview color into spannable color
		val spannableText = SpannableStringBuilder("Hai, Naufal")
		spannableText.setSpan(
			ForegroundColorSpan(orange),
			5, // start
			11, // end
			Spannable.SPAN_EXCLUSIVE_INCLUSIVE
		)
		username.text = spannableText
		val spannableHeading = SpannableStringBuilder("Mau liburan kemana\nkali ini?")
		spannableHeading.setSpan(
			ForegroundColorSpan(orange),
			4, // start
			11, // end
			Spannable.SPAN_EXCLUSIVE_INCLUSIVE
		)
		headingText.text = spannableHeading

		list.addAll(DestinationsData.listData)
		setActionBarTitle(title)
		showRecyclerCardView()
	}

	/**
	 * This function is used to display recycler view on the main activity.
	 */
	private fun showRecyclerCardView() {
		rvDestinations.layoutManager = LinearLayoutManager(this)
		val cardViewDestinationAdapter = CardViewDestinationAdapter(list)
		rvDestinations.adapter = cardViewDestinationAdapter

//		Override the onItemClicked function from Adapter
		cardViewDestinationAdapter.setOnItemClickCallback(object : CardViewDestinationAdapter.OnItemClickCallback {
			override fun onItemClicked(data: Destination) {
				showSelectedDestination(data)
			}
		})
	}

	/**
	 * This action is used to move intent to DetailDestinationActivity with carrying the clicked card's data
	 */
	private fun showSelectedDestination(destination: Destination) {
		val moveWithDataIntent = Intent(this@MainActivity, DestinationDetailsActivity::class.java)
		moveWithDataIntent.putExtra(DestinationDetailsActivity.DESTINATION_NAME, destination.name)
		moveWithDataIntent.putExtra(DestinationDetailsActivity.DESTINATION_LOCATION, destination.location)
		moveWithDataIntent.putExtra(DestinationDetailsActivity.DESTINATION_RATING, destination.rating)
		moveWithDataIntent.putExtra(DestinationDetailsActivity.DESTINATION_DETAIL, destination.detail)
		moveWithDataIntent.putExtra(DestinationDetailsActivity.DESTINATION_PRICE, destination.price)
		moveWithDataIntent.putExtra(DestinationDetailsActivity.DESTINATION_IMAGE, destination.photo)
		startActivity(moveWithDataIntent)
	}

	/**
	 * This function is used to move intent to AboutActivity
	 */
	private fun navigateToAboutActivity() {
		val moveIntent = Intent(this, AboutActivity::class.java)
		startActivity(moveIntent)
	}

	/**
	 * This function is used to change the supportActionBar if there's available title argument.
	 */
	private fun setActionBarTitle(title: String) {
		supportActionBar?.title = title
	}

	/**
	 * This function and belows are related to triple dots menu on the Action bar
	 */
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return super.onCreateOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		setMode(item.itemId)
		return super.onOptionsItemSelected(item)
	}

	/**
	 * This function are the action of the selected menu
	 */
	private fun setMode(selectedMode: Int) {
		when (selectedMode) {
			R.id.action_cardview -> {
				showRecyclerCardView()
			}

//			R.id.action_detail -> {
//
//			}

			R.id.action_about -> {
				navigateToAboutActivity()
			}
		}
	}
}