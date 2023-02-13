package fr.centralesupelec.sio.extractor.models

data class Document(
    val title: String,
    val authors: List<String>,
    val summary: String
)
