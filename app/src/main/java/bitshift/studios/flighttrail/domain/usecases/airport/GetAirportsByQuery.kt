package bitshift.studios.flighttrail.domain.usecases.airport

import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.domain.repositories.AirportDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAirportsByQuery @Inject constructor(private val airportRepository: AirportDataRepository) {
	operator fun invoke(query: String): Flow<List<AirportEntity>> {
		return airportRepository.getAirportsByQuery(query)
	}
}