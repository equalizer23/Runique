plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jvm.ktor)
}

android {
    namespace = "com.ravl.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
}