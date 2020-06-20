plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
}

repositories {
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://dl.bintray.com/cfraser/muirwik")
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1")
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.104-kotlin-1.3.72")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.104-kotlin-1.3.72")
    implementation("org.jetbrains:kotlin-react-redux:5.0.7-pre.104-kotlin-1.3.72")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    implementation("org.jetbrains:kotlin-redux:4.0.0-pre.104-kotlin-1.3.72")

    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.104-kotlin-1.3.72")
    implementation("org.jetbrains:kotlin-css-js:1.0.0-pre.104-kotlin-1.3.72")
    implementation("com.ccfraser.muirwik:muirwik-components:0.5.1")
    implementation(npm("styled-components"))
    implementation(npm("inline-style-prefixer"))
    implementation(npm("@material-ui/core", "^4.9.14"))

    testImplementation(kotlin("test-js"))
}

kotlin.target.browser { }