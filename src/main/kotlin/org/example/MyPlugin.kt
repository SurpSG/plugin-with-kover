package org.example

import org.gradle.api.Plugin
import org.gradle.api.Project

open class MyPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.logger.error("Hello from MyPlugin")
    }
}
