package com.app.sobattravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewDestinationAdapter(private val listDestination: ArrayList<Destination>):
	RecyclerView.Adapter<CardViewDestinationAdapter.CardViewViewHolder>() {

	private lateinit var onItemClickCallback : OnItemClickCallback

	fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
		this.onItemClickCallback = onItemClickCallback
	}

	interface OnItemClickCallback {
		fun onItemClicked(data: Destination)
	}

	inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var imgPhoto: ImageView = itemView.findViewById(R.id.icd_iv_destination_photo)
		var tvTitle: TextView = itemView.findViewById(R.id.icd_tv_destination_heading)
		var tvSubtitle: TextView = itemView.findViewById(R.id.icd_tv_destination_subtitle)
		var tvRating: TextView = itemView.findViewById(R.id.icd_tv_destination_rating)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
		val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_destination, parent, false)
		return CardViewViewHolder(view)
	}

	override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
		val destination = listDestination[position]

		Glide.with(holder.itemView.context)
			.load(destination.photo)
			.apply(RequestOptions().override(70, 70))
			.into(holder.imgPhoto)

		holder.tvTitle.text = destination.name
		holder.tvSubtitle.text = destination.location
		holder.tvRating.text = destination.rating.toString()

		holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listDestination[holder.adapterPosition]) }
	}

	override fun getItemCount(): Int {
		return listDestination.size
	}
}