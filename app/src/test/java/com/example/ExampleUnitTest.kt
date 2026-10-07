package com.example

import com.example.data.RomanticContentEngine
import com.example.model.RomanticCategory
import com.example.model.RomanticStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class RomanticEngineTest {

    @Test
    fun dailyStatus_isDeterministicForSameDate() {
        val testDate = LocalDate.of(2026, 10, 7)
        val status1 = RomanticContentEngine.getDailyStatus(testDate)
        val status2 = RomanticContentEngine.getDailyStatus(testDate)

        assertEquals("Daily status must be identical for the same date", status1.id, status2.id)
        assertEquals(status1.text, status2.text)
        assertNotNull(status1.stylePrompt)
    }

    @Test
    fun curatedStatuses_areNotEmptyAndNonBlank() {
        val all = RomanticContentEngine.getAllStatuses()
        assertTrue("Curated statuses list must not be empty", all.isNotEmpty())
        for (item in all) {
            assertTrue("Status text cannot be blank", item.text.isNotBlank())
            assertTrue("Status id cannot be blank", item.id.isNotBlank())
            assertNotNull(item.category)
        }
    }

    @Test
    fun formattingWithTags_appendsProperHashtags() {
        val status = RomanticStatus(
            id = "test_1",
            text = "You are my home.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("Love", "#Soulmate")
        )

        val withoutTags = status.formattedWithTags(includeTags = false)
        assertEquals("You are my home.", withoutTags)

        val withTags = status.formattedWithTags(includeTags = true)
        assertTrue(withTags.contains("#Love"))
        assertTrue(withTags.contains("#Soulmate"))
        assertTrue(withTags.startsWith("You are my home."))
    }

    @Test
    fun randomStatus_respectsRequestedCategory() {
        for (category in RomanticCategory.entries) {
            if (category == RomanticCategory.ALL) continue
            val status = RomanticContentEngine.getRandomStatus(category)
            assertEquals("Should match selected category", category, status.category)
        }
    }

    @Test
    fun aiStyleGeneration_producesValidContent() {
        val generated = RomanticContentEngine.generateAiStyleStatus(RomanticCategory.SWEET)
        assertNotNull(generated)
        assertTrue(generated.text.isNotBlank())
        assertFalse(generated.tags.isEmpty())
    }

    @Test
    fun adConfig_containsValidUnitIds() {
        assertEquals("ca-app-pub-5222053984568989~5680583880", com.example.ad.AdConfig.APP_ID)
        assertEquals("ca-app-pub-5222053984568989/2859724289", com.example.ad.AdConfig.BANNER_AD_UNIT_ID)
        assertEquals("ca-app-pub-5222053984568989/9233560948", com.example.ad.AdConfig.INTERSTITIAL_AD_UNIT_ID)
    }
}
