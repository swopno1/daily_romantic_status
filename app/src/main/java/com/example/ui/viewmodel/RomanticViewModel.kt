package com.example.ui.viewmodel

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.FavoritesRepository
import com.example.data.RomanticContentEngine
import com.example.model.RomanticCategory
import com.example.model.RomanticStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RomanticViewModel(application: Application) : AndroidViewModel(application) {

    private val favoritesRepository = FavoritesRepository(application.applicationContext)

    val favorites: StateFlow<List<RomanticStatus>> = favoritesRepository.favorites
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _selectedCategory = MutableStateFlow(RomanticCategory.ALL)
    val selectedCategory: StateFlow<RomanticCategory> = _selectedCategory.asStateFlow()

    private val _currentStatus = MutableStateFlow(
        RomanticContentEngine.getDailyStatus().let { daily ->
            daily.copy(isFavorite = favoritesRepository.isFavorite(daily.id))
        }
    )
    val currentStatus: StateFlow<RomanticStatus> = _currentStatus.asStateFlow()

    private val _isGenerating = MutableStateFlow(false)
    val isGenerating: StateFlow<Boolean> = _isGenerating.asStateFlow()

    private val _generationHint = MutableStateFlow("AI Romantic Craft")
    val generationHint: StateFlow<String> = _generationHint.asStateFlow()

    private val _includeHashtags = MutableStateFlow(false)
    val includeHashtags: StateFlow<Boolean> = _includeHashtags.asStateFlow()

    private val _toastMessage = MutableStateFlow<String?>(null)
    val toastMessage: StateFlow<String?> = _toastMessage.asStateFlow()

    private val _showFavoritesSheet = MutableStateFlow(false)
    val showFavoritesSheet: StateFlow<Boolean> = _showFavoritesSheet.asStateFlow()

    private val _showAboutDialog = MutableStateFlow(false)
    val showAboutDialog: StateFlow<Boolean> = _showAboutDialog.asStateFlow()

    private val _showCardShareDialog = MutableStateFlow(false)
    val showCardShareDialog: StateFlow<Boolean> = _showCardShareDialog.asStateFlow()

    private val craftHints = listOf(
        "Crafting romantic words...",
        "Polishing tender phrases...",
        "Harmonizing heartbeats...",
        "Selecting poetic sentiments...",
        "Adding warm romantic sparkle..."
    )

    fun selectCategory(category: RomanticCategory) {
        _selectedCategory.value = category
        if (category == RomanticCategory.ALL) {
            val daily = RomanticContentEngine.getDailyStatus()
            _currentStatus.value = daily.copy(isFavorite = favoritesRepository.isFavorite(daily.id))
        } else {
            generateNext()
        }
    }

    fun generateNext() {
        if (_isGenerating.value) return
        viewModelScope.launch {
            _isGenerating.value = true
            _generationHint.value = craftHints.random()
            // Micro-delay gives the user a tangible feeling of thoughtful synthesis
            delay(350)
            val newStatus = RomanticContentEngine.generateAiStyleStatus(_selectedCategory.value)
            val withFav = newStatus.copy(isFavorite = favoritesRepository.isFavorite(newStatus.id))
            _currentStatus.value = withFav
            _isGenerating.value = false
        }
    }

    fun toggleFavorite(status: RomanticStatus) {
        val nowFavorite = favoritesRepository.toggleFavorite(status)
        if (_currentStatus.value.id == status.id) {
            _currentStatus.value = _currentStatus.value.copy(isFavorite = nowFavorite)
        }
        _toastMessage.value = if (nowFavorite) "Added to Favorites 💖" else "Removed from Favorites"
    }

    fun toggleIncludeHashtags() {
        _includeHashtags.value = !_includeHashtags.value
    }

    fun copyToClipboard(context: Context, status: RomanticStatus) {
        val textToCopy = status.formattedWithTags(_includeHashtags.value)
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Romantic Status", textToCopy)
        clipboard.setPrimaryClip(clip)
        _toastMessage.value = "Copied to clipboard! 📋"
    }

    fun shareStatus(context: Context, status: RomanticStatus) {
        val shareText = buildString {
            append(status.formattedWithTags(_includeHashtags.value))
            append("\n\n— via Daily Romantic Status")
        }
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
            putExtra(Intent.EXTRA_SUBJECT, "Romantic Status")
        }
        val chooser = Intent.createChooser(intent, "Share Romantic Status via")
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(chooser)
    }

    fun clearToastMessage() {
        _toastMessage.value = null
    }

    fun openFavorites() { _showFavoritesSheet.value = true }
    fun closeFavorites() { _showFavoritesSheet.value = false }

    fun openAbout() { _showAboutDialog.value = true }
    fun closeAbout() { _showAboutDialog.value = false }

    fun openCardShare() { _showCardShareDialog.value = true }
    fun closeCardShare() { _showCardShareDialog.value = false }
}
