package bitshift.studios.flighttrail.data.db.airport

import androidx.room.Dao
import androidx.room.Query
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
	@Query(
		"""
			SELECT * FROM airport 
			WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR 
			LOWER(iata_code) LIKE '%' || LOWER(:query) || '%'
			ORDER BY passengers DESC
		"""
	)
	fun getAirportsByQuery(query: String): Flow<List<AirportEntity>>
}