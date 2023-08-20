package bitshift.studios.flighttrail.data.db.airport.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportEntity(
	@PrimaryKey
	val id: Int,
	@ColumnInfo(name = "iata_code")
	val iataCode: String,
	@ColumnInfo(name = "name")
	val name: String,
	@ColumnInfo(name = "passengers")
	val passengers: Int
)