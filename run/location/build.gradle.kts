plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.ravl.run.location"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.koin)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    implementation(projects.run.domain)
    implementation(projects.core.domain)
}