plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.pplgsmkn4.laporanmasyarakat"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.pplgsmkn4.laporanmasyarakat"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    buildFeatures {
        // Dibutuhkan karena kode memakai BuildConfig.APPLICATION_ID
        // (authority FileProvider di ReportActivity).
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.activity)
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.cardview)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.recyclerview)

    // Lifecycle (ViewModel + LiveData)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.viewmodel)

    // Room Database (persistence laporan)
    implementation(libs.room.runtime)
    implementation(libs.room.rxjava3)
    annotationProcessor(libs.room.compiler)

    // Glide (menampilkan gambar dari Base64/Bitmap)
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    // RxJava 3 (eksekusi query Room di background thread)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)

    // Lokasi otomatis (FusedLocationProviderClient)
    implementation(libs.play.services.location)

    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}
