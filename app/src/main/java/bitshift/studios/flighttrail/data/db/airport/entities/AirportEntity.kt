package bitshift.studios.flighttrail.data.db.airport.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportEntity(
	@PrimaryKey
	val id: Int,
	val iataCode: String,
	val name: String,
	val passengers: Int
)