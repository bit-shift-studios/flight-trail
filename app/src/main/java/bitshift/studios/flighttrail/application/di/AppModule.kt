package bitshift.studios.flighttrail.application.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import bitshift.studios.flighttrail.data.datastore.OnboardingDataStore
import bitshift.studios.flighttrail.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
	@Provides
	@Singleton
	fun provideOnboardingDataStore(@ApplicationContext context: Context): OnboardingDataStore {
		return OnboardingDataStore(context)
	}

	@Provides
	@Singleton
	fun provideDatabase(app: Application): AppDatabase {
		return Room.databaseBuilder(
			app.applicationContext,
			AppDatabase::class.java,
			AppDatabase.databaseName
		)
			.createFromAsset("database/flight_search.db")
			.build()
	}
}