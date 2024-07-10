import com.android.build.api.dsl.LibraryExtension
import com.ravl.convention.ExtensionType
import com.ravl.convention.configureAndroidCompose
import com.ravl.convention.configureBuildTypes
import com.ravl.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run{
            pluginManager.run {
                apply("runique.android.library")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }

}