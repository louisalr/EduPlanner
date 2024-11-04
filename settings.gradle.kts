enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EduPlanner"
include(":androidApp")
include(":shared")
include(":shared:ui")
include(":shared:presentation")
include(":shared:presentation:ui")
include(":shared:data")
include(":shared:domain")
include(":shared:entity")
include(":shared:data:user")
include(":shared:domain:user")
include(":shared:entity:user")
include(":shared:presentation:viewmodels")
include(":shared:core")
include(":shared:core:http")
include(":shared:core:preferences")
