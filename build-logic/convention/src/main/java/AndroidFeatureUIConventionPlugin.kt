
import com.ravl.convention.addComposeDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureUIConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run{
            pluginManager.run {
                apply("runique.android.library.compose")
            }

           dependencies {
                addComposeDependencies(target)
           }
        }
    }

}