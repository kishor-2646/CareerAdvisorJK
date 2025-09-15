import org.gradle.kotlin.dsl.dependencies

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Make the Android Application plugin AVAILABLE to modules
    id("com.android.application") version "8.4.1" apply false

    // Make the Kotlin Android plugin AVAILABLE to modules
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}

