package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.RomanticCategory
import com.example.model.RomanticStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject

class FavoritesRepository(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("daily_romantic_favorites", Context.MODE_PRIVATE)

    private val _favorites = MutableStateFlow<List<RomanticStatus>>(emptyList())
    val favorites: StateFlow<List<RomanticStatus>> = _favorites.asStateFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        val jsonString = prefs.getString(KEY_FAVORITES, null) ?: "[]"
        val list = mutableListOf<RomanticStatus>()
        try {
            val array = JSONArray(jsonString)
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                val catName = obj.optString("category", RomanticCategory.SWEET.name)
                val cat = try {
                    RomanticCategory.valueOf(catName)
                } catch (e: Exception) {
                    RomanticCategory.SWEET
                }
                val tagsArray = obj.optJSONArray("tags")
                val tagsList = mutableListOf<String>()
                if (tagsArray != null) {
                    for (t in 0 until tagsArray.length()) {
                        tagsList.add(tagsArray.getString(t))
                    }
                }
                list.add(
                    RomanticStatus(
                        id = obj.getString("id"),
                        text = obj.getString("text"),
                        category = cat,
                        tags = tagsList,
                        stylePrompt = obj.optString("stylePrompt", "Saved Favorite"),
                        isFavorite = true
                    )
                )
            }
        } catch (e: Exception) {
            // Graceful fallback if corrupted
        }
        _favorites.value = list
    }

    private fun saveFavorites(list: List<RomanticStatus>) {
        val array = JSONArray()
        for (item in list) {
            val obj = JSONObject().apply {
                put("id", item.id)
                put("text", item.text)
                put("category", item.category.name)
                put("stylePrompt", item.stylePrompt)
                val tagsArray = JSONArray()
                item.tags.forEach { tagsArray.put(it) }
                put("tags", tagsArray)
            }
            array.put(obj)
        }
        prefs.edit().putString(KEY_FAVORITES, array.toString()).apply()
        _favorites.value = list
    }

    fun isFavorite(id: String): Boolean {
        return _favorites.value.any { it.id == id }
    }

    fun toggleFavorite(status: RomanticStatus): Boolean {
        val current = _favorites.value.toMutableList()
        val existingIndex = current.indexOfFirst { it.id == status.id }
        val nowFavorite: Boolean
        if (existingIndex >= 0) {
            current.removeAt(existingIndex)
            nowFavorite = false
        } else {
            current.add(0, status.copy(isFavorite = true))
            nowFavorite = true
        }
        saveFavorites(current)
        return nowFavorite
    }

    fun removeFavorite(id: String) {
        val current = _favorites.value.toMutableList()
        current.removeAll { it.id == id }
        saveFavorites(current)
    }

    companion object {
        private const val KEY_FAVORITES = "saved_favorites_json"
    }
}
