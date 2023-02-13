package fr.centralesupelec.sio.extractor

import fr.centralesupelec.sio.extractor.models.Document

/**
 * Repository class for documents.
 */
// Creating "repository" classes to access data is a good architecture practice.
// The repository acts as a central point for every part of the application that need to access business data.
// In Kotlin, no need for the singleton pattern, one can define a simple standalone "object" (no instantiation).
object DocumentsRepository {

    // In this demo, the documents are stored as a non-persistent in-memory list, populated at initialization.
    // In a real-life implementation, we would rely on a database instead.
    // In Kotlin, it is possible to instantiate directly a field with a initial value.
    // This field is a "val", i.e. it is readonly (final).
    private val allDocuments: List<Document> = listOf(
        // Here we instantiate the Document classes. Kotlin does not use the "new" keyword.
        Document("Hello ChatGPT", listOf("Momo", "Charles"), "Ipsum lorem"),
        Document("Hi Siri", listOf("Steve"), "Ipsum lorem"),
        Document("Hey Google", listOf("Larry"), "Ipsum lorem")
    )

    // A method to list documents, accepting optional filtering parameters.
    fun getDocuments(title: String? = null, author: String? = null, summary: String? = null): List<Document> {
        // Lists and other iterable types are filterable out-of-the-box in Kotlin, through extension methods.
        return allDocuments.filter { doc ->
            // Case-insensitive string comparison is provided by the Kotlin standard library.
            (title == null || doc.title.contains(title, ignoreCase = true))
                    && (author == null || doc.authors.any { it.contains(author, ignoreCase = true) })
                    && (summary == null || doc.summary.contains(summary, ignoreCase = true))
        }
    }

}