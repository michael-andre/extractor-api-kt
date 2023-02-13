package fr.centralesupelec.sio.extractor

import fr.centralesupelec.sio.extractor.models.Document
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for API routes related to search of documents.
 */
// In Spring, we can isolate code related to some API routes in a dedicated "controller" class.
// The class must be annotated with this Spring annotation to enable registration of routes by the framework.
@RestController
class DocumentsController {

    // Individual route handling is defined by a method of a controller, annotated with the @XxxMapping annotation.
    // The (unique) string parameter of the annotation is the API path to associate with this method.
    // The returned value is a List of Document instances, it will automatically be serialized to JSON by Spring.
    // In Kotlin, everything is non-null (parameter, return type, variable) except noted otherwise with "Type?".
    @GetMapping("search")
    fun searchDocuments(
        // In Kotlin, methods can have parameters with default values (they become optional)
        @RequestParam title: String? = null,
        @RequestParam author: String? = null,
        @RequestParam summary: String? = null
    ): List<Document> {

        // TODO: Validate parameters here
        // Here, before calling the repository, we should validate the parameters provided by the client.

        return DocumentsRepository.getDocuments(title, author, summary)
    }

}