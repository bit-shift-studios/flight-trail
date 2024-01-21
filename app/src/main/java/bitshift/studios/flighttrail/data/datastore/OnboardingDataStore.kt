package bitshift.studios.flighttrail.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "pref_onboarding")

class OnboardingDataStore(context: Context) {
	private val dataStore = context.datastore

	private object PreferencesKeys {
		val ONBOARDING_COMPLETED = booleanPreferencesKey(name = "onboarding_completed")
	}

	suspend fun saveOnboardingState(completed: Boolean) {
		dataStore.edit { preferences ->
			preferences[PreferencesKeys.ONBOARDING_COMPLETED] = completed
		}
	}

	fun readOnboardingState(): Flow<Boolean> {
		return dataStore.data
			.catch { exception ->
				if (exception is IOException) {
					emit(emptyPreferences())
				} else {
					throw exception
				}
			}
			.map { preferences ->
				val onBoardingState = preferences[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
				onBoardingState
			}
	}
}