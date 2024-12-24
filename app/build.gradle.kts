plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
//    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.mvvm_hilt_db_retrofit_room"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mvvm_hilt_db_retrofit_room"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //DataBinding
//    implementation ("androidx.databinding:databinding-runtime:8.7.3")
//    kapt ("androidx.databinding:databinding-compiler:8.7.3")

    // retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson) // gson converter
    implementation (libs.logging.interceptor) // OkHttp logging interceptor (for debugging API requests)

    // ViewModel and LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.kotlinx.coroutines.android) // Kotlin Coroutines for background tasks

    // Dagger for Dependency Injection
//    implementation (libs.dagger)
//    ksp (libs.dagger.compiler)

    // Hilt Dagger Dependency
    implementation (libs.hilt.android) // Replace with the latest version
    kapt (libs.hilt.android.compiler)

    //Room for internal DB Sqlite
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}