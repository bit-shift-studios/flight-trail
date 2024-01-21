package bitshift.studios.flighttrail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flighttrail.application.navigation.routes.AppNavRoutes
import bitshift.studios.flighttrail.data.datastore.OnboardingDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val onboardingDataStore: OnboardingDataStore
): ViewModel() {
	private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
	val isLoading: State<Boolean> = _isLoading

	private val _startDestination: MutableState<String> = mutableStateOf(AppNavRoutes.onboarding)
	val startDestination: State<String> = _startDestination

	init {
		viewModelScope.launch {
			onboardingDataStore.readOnboardingState().collect { isCompleted ->
				if (isCompleted) {
					_startDestination.value = AppNavRoutes.home
				} else {
					_startDestination.value = AppNavRoutes.onboarding
				}

				delay(80)
				_isLoading.value = false
			}
		}
	}
}