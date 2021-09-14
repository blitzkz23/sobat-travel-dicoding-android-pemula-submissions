package com.app.sobattravel

object DestinationsData {
	private val destinationNames = arrayOf(
		"Honolulu Island",
		"Carlton Hill",
		"Copenhagen",
		"Kruger Nationals Park",
		"Machu Picchu",
		"Tokyo Skytree",
		"Bora Bora",
		"Eiffel Tower",
		"Westminster Bridge",
		"Cinque Terre"
	)

	private val destinationLocations = arrayOf(
		"Hawaii",
		"Edinburgh, Scotland",
		"Denmark",
		"South Africa",
		"Peru",
		"Tokyo",
		"French Polynesia",
		"Paris, France",
		"London, England",
		"Italy"
	)

	private val destinationDetails = arrayOf(
		"From the hustle and bustle of Oahu to the romance of Maui and off-the-beaten-path adventures on Lanai and Molokai. The Hawaiian Islands are pure paradise. Explore colorful canyons and waterfalls and eat your body weight in fresh poke.",
		"With the historic Edinburgh castle looming over the city, culture in spades and wonderfully friendly locals, this is one of the world’s greatest city breaks.",
		"Copenhagen’s rustic fishing ports, modern graffiti and winding red brick streets are just some of what makes it such a beautiful bucket list destination. It oozes Scandi cool from every corner, with top-notch food, stylish design and an always hip atmosphere.",
		"The Kruger National Park is a vast space in northeastern South Africa that is home to a huge array of wildlife. The park has safari experiences of all kinds, allowing you the opportunity to escape busy city living and get back to nature.",
		"The best way to get here? Arrive at Machu Picchu in style on the 360° Train that will bring you through the Peruvian countryside to the lost city. The wide, panoramic windows are perfect for soaking up the view, plus they serve Pisco Sours on board.",
		"Visiting Tokyo is like visiting the future—flashing neon lights, incredible technology—yet there’s still a rich sense of culture and history.",
		"Bora Bora is Tahiti's most famous island. How do overwater bungalows and underwater adventures sound to you? To us, it’s everything we could want from a bucket list destination.",
		"One of the most iconic cities in the world, Paris tops many people’s bucket lists. You’ll see so many famous landmarks here: the Eiffel Tower, Arc de Triomphe, Notre Dame cathedral—the list is never-ending.",
		"Pretty pink restaurants, futuristic space-age toilets and jungle skyline views are just some of our favorite things about London. And of course, all the classics: Big Ben, red phone boxes and world-class museums and galleries.",
		"Is there anything prettier than this area of centuries-old seaside villages on the rugged Italian Riviera coastline? The five towns (Manarola, Riomaggiore, Corniglia, Vernazza and Monterosso al Mare) are made for bucket lists."

	)

	private val destinationImages = intArrayOf(
		R.drawable.honolulu_island_hawaii,
		R.drawable.carlton_hill_edinburgh,
		R.drawable.copenhagen_denmark,
		R.drawable.kruger_park_south_africa,
		R.drawable.machu_picchu_peru,
		R.drawable.tokyo_skytree_tokyo,
		R.drawable.bora_bora_french,
		R.drawable.eiffel_tower_paris,
		R.drawable.london_westminster_bridge,
		R.drawable.vernazza_italy
	)

	private val destinationRatings = doubleArrayOf(
		4.8,
		4.5,
		4.9,
		4.4,
		4.7,
		5.0,
		4.8,
		4.5,
		4.6,
		4.2
	)

	private val destinationPrices = intArrayOf(
		2400000,
		1400000,
		1600000,
		2600000,
		1550000,
		1900000,
		1200000,
		2100000,
		1700000,
		2000000
	)

	val listData: ArrayList<Destination>
		get() {
			val list = arrayListOf<Destination>()
			for (position in destinationNames.indices) {
				val destination = Destination()
				destination.name = destinationNames[position]
				destination.location = destinationLocations[position]
				destination.detail = destinationDetails[position]
				destination.rating = destinationRatings[position]
				destination.photo = destinationImages[position]
				destination.price = destinationPrices[position]
				list.add(destination)
			}
			return list
		}
}