
plugins {
    `application`
}

application {
    mainClass.set("demo.app.AppKt")
}

dependencies {
    api(project(":common"))
}
