object ApplicationId {
    val id = "com.wonkijo.newsfeed"
}

object Versions {
    val kotlin = "1.3.61"
    val gradlePlugin = "3.5.2"
    val versionCode = 1
    val versionName = "1.0"
    val compileSdk = 28
    val buildTool = "28.0.3"
    val minSdk = 21
    val targetSdk = 28

    val dagger = "2.23.2"

    val rxKotlin = "2.3.0"
    val rxAndroid = "2.1.1"
    val rxBinding = "3.0.0"

    val timber = "4.7.1"

    val appCompat = "1.0.2"
    val coreKtx = "1.0.2"
    val materialDesign = "1.0.0"
    val constraintLayout = "1.1.3"
    val lifecycle = "2.0.0"

    val glide = "4.8.0"
    
    val retrofit2 = "2.5.0"
    val okhttp3 = "3.12.0"
    
    // todo : retrofit
    // todo : xml converter
    // todo : jsoup?
    // todo : cache with room
    val room = "2.0.0"
    // todo : testing


    // todo : coroutine
    // todo : mvi
}

object Dependencies {
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Dagger2
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    // REACTIVEX
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Versions.rxBinding}"

    // Android
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    // Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    // Network
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2}"
    val converterXml = "com.squareup.retrofit2:converter-simplexml:${Versions.retrofit2}"

//    val room = "androidx.room:room-runtime:${Versions.room}"
//    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

//    // For testing
//    junit                   : "junit:junit:${Versions.junit}",
//    kotlinTest              : "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}",
//    mockito                 : "org.mockito:mockito-core:${Versions.mockito}",
//    roomTest                : "androidx.room:room-testing:${Versions.room}",
//    robolectric             : "org.robolectric:robolectric:${Versions.robolectric}",
//    truth                   : "androidx.test.ext:truth:${Versions.truth}",
//
//    androidTestCore         : "androidx.test:core:${Versions.androidTest}",
//    androidTestCoreKtx      : "androidx.test:core-ktx:${Versions.androidTest}",
//    androidTestJUnit        : "androidx.test.ext:junit:${Versions.androidTest}",
//    androidTestJUnitKtx     : "androidx.test.ext:junit-ktx:${Versions.androidTest}",
//    androidTestRunner       : "androidx.test:runner:${Versions.androidTest}",
//    androidTestRules        : "androidx.test:rules:${Versions.androidTest}",
//    espressoCore            : "androidx.test.espresso:espresso-core:${Versions.espresso}",
//    espressoIntents         : "androidx.test.espresso:espresso-intents:${Versions.espresso}"
}