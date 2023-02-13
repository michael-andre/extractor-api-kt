package fr.centralesupelec.sio.extractor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// The main class of our server program.
// Following Spring architecture, the main class must be decorated with this annotation to enable discovery.
// The framework will then inspect the classes in the package to automatically register their features.
// The class is actually totally empty (no need for curly brackets in Kotlin).
@SpringBootApplication
class ExtractorApiApplication

// In Kotlin, a function can be defined outside a class, and one can put many things in a single file.
// A top-level main function is eligible as an entrypoint.
fun main(args: Array<String>) {
    // We simply launch the framework be providing the root class of the application (ourselves).
    runApplication<ExtractorApiApplication>(*args)
}