package bitshift.studios.flighttrail.application.di

import android.app.Application
import androidx.room.Room
import bitshift.studios.flighttrail.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

	@Provides
	@Singleton
	fun providesDatabase(app: Application): AppDatabase {
		return Room.databaseBuilder(
			app.applicationContext,
			AppDatabase::class.java,
			AppDatabase.databaseName
		)
			.createFromAsset("database/flight_search.db")
			.build()
	}
}