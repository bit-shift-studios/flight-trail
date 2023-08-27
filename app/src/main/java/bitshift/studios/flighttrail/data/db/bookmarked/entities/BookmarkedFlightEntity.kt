package bitshift.studios.flighttrail.data.db.bookmarked.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked")
data class BookmarkedFlightEntity (
	@PrimaryKey
	val id: Int,
	@ColumnInfo(name = "departure_code")
	val departureCode: String,
	@ColumnInfo(name = "destination_code")
	val destinationCode: String
)