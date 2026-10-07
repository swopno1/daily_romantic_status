package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.FavoritesRepository
import com.example.data.RomanticContentEngine
import com.example.model.RomanticCategory
import com.example.model.RomanticStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun readStringFromContext_matchesAppName() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Daily Romantic Status", appName)
    }

    @Test
    fun favoritesRepository_persistsAndTogglesFavorites() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repo = FavoritesRepository(context)

        val testStatus = RomanticStatus(
            id = "test_fav_01",
            text = "Loving you is like breathing.",
            category = RomanticCategory.SWEET,
            tags = listOf("Love", "Forever")
        )

        // Initial state
        assertFalse(repo.isFavorite(testStatus.id))

        // Toggle to true
        val isNowFav = repo.toggleFavorite(testStatus)
        assertTrue(isNowFav)
        assertTrue(repo.isFavorite(testStatus.id))
        assertTrue(repo.favorites.value.any { it.id == testStatus.id })

        // Toggle to false
        val removed = repo.toggleFavorite(testStatus)
        assertFalse(removed)
        assertFalse(repo.isFavorite(testStatus.id))
    }
}
