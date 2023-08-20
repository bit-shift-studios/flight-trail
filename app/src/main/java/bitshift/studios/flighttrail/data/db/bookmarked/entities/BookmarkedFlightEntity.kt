package bitshift.studios.flighttrail.data.db.bookmarked.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked")
data class BookmarkedFlightEntity (
	@PrimaryKey
	val id: Int,
	val departureCode: String,
	val destinationCode: String
)