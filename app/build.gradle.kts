plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
	id("com.google.devtools.ksp")
	id("com.google.dagger.hilt.android")
	kotlin("kapt")
}

android {
	namespace = "bitshift.studios.flighttrail"
	compileSdk = 33

	defaultConfig {
		applicationId = "bitshift.studios.flighttrail"
		minSdk = 24
		targetSdk = 33
		versionCode = 1
		versionName = "1.1"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.4.3"
	}
	java {
		toolchain {
			languageVersion.set(JavaLanguageVersion.of(17))
		}
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	val composeCoreVersion = "1.10.1"
	val activityComposeVersion = "1.7.2"
	val lifecycleRuntimeVersion = "2.6.1"
	val lifeCycleViewModelComposeVersion = "2.6.1"
	val composeBOMVersion = "2023.03.00"
	val jUnitVersion = "4.13.2"
	val roomVersion = "2.5.2"
	val hiltVersion = "2.44.2"
	val navigationVersion = "2.7.0-beta01"
	val splashVersion = "1.0.1"
	val hiltNavigationComposeVersion = "1.0.0"
	val dataStoreVersion = "1.0.0"

	implementation("androidx.core:core-ktx:$composeCoreVersion")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion")
	implementation("androidx.activity:activity-compose:$activityComposeVersion")
	implementation(platform("androidx.compose:compose-bom:$composeBOMVersion"))
	implementation("androidx.compose.ui:ui")
	implementation("androidx.compose.ui:ui-graphics")
	implementation("androidx.compose.ui:ui-tooling-preview")
	implementation("androidx.compose.material3:material3")

	// RoomDB
	implementation("androidx.room:room-runtime:$roomVersion")
	implementation("androidx.room:room-ktx:$roomVersion")
	ksp("androidx.room:room-compiler:$roomVersion")

	// Preferences Datastore
	implementation("androidx.datastore:datastore-preferences:$dataStoreVersion")

	// Hilt
	implementation("com.google.dagger:hilt-android:$hiltVersion")
	implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion")
	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifeCycleViewModelComposeVersion")
	kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

	// Navigation
	implementation("androidx.navigation:navigation-compose:$navigationVersion")

	// Splash API
	implementation("androidx.core:core-splashscreen:$splashVersion")

	// Testing
	testImplementation("junit:junit:$jUnitVersion")
	androidTestImplementation("androidx.test.ext:junit:1.1.5")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
	androidTestImplementation(platform("androidx.compose:compose-bom:$composeBOMVersion"))
	androidTestImplementation("androidx.compose.ui:ui-test-junit4")
	debugImplementation("androidx.compose.ui:ui-tooling")
	debugImplementation("androidx.compose.ui:ui-test-manifest")
}