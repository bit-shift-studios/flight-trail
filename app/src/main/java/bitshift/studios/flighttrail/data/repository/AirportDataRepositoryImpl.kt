package bitshift.studios.flighttrail.data.repository

import bitshift.studios.flighttrail.data.db.airport.AirportDao
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.domain.repositories.AirportDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AirportDataRepositoryImpl @Inject constructor(private val airportDao: AirportDao) : AirportDataRepository {
	override fun getAirportsByQuery(query: String): Flow<List<AirportEntity>> {
		return airportDao.getAirportsByQuery(query)
	}
}