package bitshift.studios.flighttrail.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import bitshift.studios.flighttrail.data.db.airport.AirportDao
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.data.db.bookmarked.BookmarkedFlightDao
import bitshift.studios.flighttrail.data.db.bookmarked.entities.BookmarkedFlightEntity

@Database(
	entities = [AirportEntity::class, BookmarkedFlightEntity::class],
	exportSchema = false,
	version = 2
)
abstract class AppDatabase : RoomDatabase() {
	abstract fun airportDao(): AirportDao
	abstract fun bookmarkedFlightDao(): BookmarkedFlightDao

	companion object {
		const val databaseName = "app_database"
	}
}