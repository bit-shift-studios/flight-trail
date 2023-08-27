package bitshift.studios.flighttrail.presentation.screens.home.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUIState(
	var search: String = "",
	var showInfoModal: Boolean = false,
	var airportResults: List<AirportEntity> = emptyList()
)

private const val TAG = "HOME_VIEWMODEL"

@HiltViewModel
class HomeViewModel @Inject constructor(
	private val appUseCases: AppUseCases
) : ViewModel() {
	private val _homeUIState = MutableStateFlow(HomeUIState())
	val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

	private val scope = viewModelScope

	fun getAirportsByQuery(query: String) {
		scope.launch(context = Dispatchers.IO) {
			Log.d(TAG, "EXECUTED SEARCH QUERY")
			appUseCases.getAirportsByQuery(query).collect { airports ->
				_homeUIState.update { state ->
					state.copy(
						airportResults = airports
					)
				}
			}
		}
	}

	fun updateInfoModalVisibility(visibility: Boolean) {
		_homeUIState.update { state ->
			state.copy(
				showInfoModal = visibility
			)
		}
	}

	fun updateSearch(query: String) {
		_homeUIState.update { state ->
			state.copy(
				search = query
			)
		}
	}

	fun clearSearch() {
		_homeUIState.update { state ->
			state.copy(
				search = ""
			)
		}
	}
}