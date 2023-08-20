package bitshift.studios.flighttrail.data.db.bookmarked

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bitshift.studios.flighttrail.data.db.bookmarked.entities.BookmarkedFlightEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkedFlightDao {
	@Query(
		"""
			SELECT * FROM bookmarked
		"""
	)
	fun getBookmarkedFlights(): Flow<List<BookmarkedFlightEntity>>

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	suspend fun bookmarkFlight(flight: BookmarkedFlightEntity)

	@Delete
	suspend fun removeFlight(flight: BookmarkedFlightEntity)
}