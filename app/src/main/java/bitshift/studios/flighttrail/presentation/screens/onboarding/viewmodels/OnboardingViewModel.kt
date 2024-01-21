package bitshift.studios.flighttrail.presentation.screens.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flighttrail.data.datastore.OnboardingDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
	private val onboardingDataStore: OnboardingDataStore
) : ViewModel() {

	fun saveOnBoardingState(completed: Boolean) {
		viewModelScope.launch(Dispatchers.IO) {
			onboardingDataStore.saveOnboardingState(completed)
		}
	}
}