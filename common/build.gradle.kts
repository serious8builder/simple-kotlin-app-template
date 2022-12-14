import Versions.withVer

plugins {

}


dependencies {
    // Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core".withVer(Versions.kotlinx_coroutines))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-reactor".withVer(Versions.kotlinx_coroutines))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-reactive".withVer(Versions.kotlinx_coroutines))

}
