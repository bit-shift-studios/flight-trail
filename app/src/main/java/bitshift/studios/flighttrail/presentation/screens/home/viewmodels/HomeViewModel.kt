package bitshift.studios.flighttrail.presentation.screens.home.viewmodels

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class HomeUIState(
	var search: String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor() {
	private val _homeUIState = MutableStateFlow(HomeUIState())
	val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

	fun updateSearch(query: String) {
		_homeUIState.update { state ->
			state.copy(
				search = query
			)
		}
	}
}