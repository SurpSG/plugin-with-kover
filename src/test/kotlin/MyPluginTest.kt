import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class MyPluginTest {

    @Test
    fun `apply plugin test`() {
        val project: Project = ProjectBuilder.builder().build()
        project.pluginManager.apply("org.jetbrains.kotlin.jvm")
        project.pluginManager.apply("org.example.plugin-with-cover")
    }

}
