package bitshift.studios.flighttrail.presentation.screens.home.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUIState(
	var search: String = "",
	var showInfoModal: Boolean = false
)

private const val TAG = "HOME VIEWMODEL"

@HiltViewModel
class HomeViewModel @Inject constructor(
	appUseCases: AppUseCases
) : ViewModel() {
	private val _homeUIState = MutableStateFlow(HomeUIState())
	val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

	private val scope = viewModelScope

	init {
		scope.launch {
			lateinit var result: List<AirportEntity>

			appUseCases.getAirportsByQuery("DUB").collect { airports ->
				result = airports
			}

			Log.d(TAG, result.toString())
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