package bitshift.studios.flighttrail.domain.usecases

import bitshift.studios.flighttrail.domain.usecases.airport.GetAirportsByQuery

data class AppUseCases (
	val getAirportsByQuery: GetAirportsByQuery
)