package bitshift.studios.flighttrail.data.repository

import bitshift.studios.flighttrail.data.db.airport.AirportDao
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.domain.repositories.AirportDataRepository
import kotlinx.coroutines.flow.Flow

class AirportDataRepositoryImpl (private val airportDao: AirportDao) : AirportDataRepository {
	override fun getMatchingAirports(query: String): Flow<List<AirportEntity>> {
		return airportDao.getAirportsByQuery(query)
	}
}