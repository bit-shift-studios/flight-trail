package bitshift.studios.flighttrail.domain.repositories

import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow

interface AirportDataRepository {
	fun getMatchingAirports(query: String): Flow<List<AirportEntity>>
}