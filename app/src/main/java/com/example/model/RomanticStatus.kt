package com.example.model

data class RomanticStatus(
    val id: String,
    val text: String,
    val category: RomanticCategory,
    val tags: List<String> = emptyList(),
    val stylePrompt: String = "AI Romantic Craft",
    val isFavorite: Boolean = false
) {
    fun formattedWithTags(includeTags: Boolean): String {
        return if (includeTags && tags.isNotEmpty()) {
            val tagString = tags.joinToString(" ") { if (it.startsWith("#")) it else "#$it" }
            "$text\n\n$tagString"
        } else {
            text
        }
    }
}
