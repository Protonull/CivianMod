// Update Gradle Wrapper using: ./gradlew wrapper --distribution-type bin --gradle-version <version>
// See Gradle's releases here: https://gradle.org/releases/

plugins {
    id("java")
    // Git Patcher (https://github.com/zml2008/gitpatcher)
    id("ca.stellardrift.gitpatcher") version "1.1.0"
}

group = "uk.protonull.civ.civmodern"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

gitPatcher.patchedRepos {
    create("CivModern") {
        submodule = "upstream"
        target.set(File("project"))
        patches.set(File("patches"))
    }
}
