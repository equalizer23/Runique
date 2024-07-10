plugins {
    `kotlin-dsl`
}

group = "com.ravl.runique.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin{
    plugins{
        register("androidApplication"){
            id = "runique.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose"){
            id = "runique.android.application.compose"
            implementationClass = "AndroidApplicationComposeConvention"
        }

        register("androidLibrary"){
            id = "runique.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose"){
            id = "runique.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeatureUi"){
            id = "runique.android.feature.ui"
            implementationClass = "AndroidFeatureUIConventionPlugin"
        }

        register("androidRoom"){
            id = "runique.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("jvmLibrary"){
            id = "runique.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("jvmKtor"){
            id = "runique.jvm.ktor"
            implementationClass = "JvmKtorConventionPlugin"
        }
    }
    
}