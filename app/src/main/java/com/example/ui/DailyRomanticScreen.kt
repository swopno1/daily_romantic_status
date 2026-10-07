package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ad.BannerAdContainer
import com.example.model.RomanticCategory
import com.example.ui.components.AboutDialog
import com.example.ui.components.CardShareDialog
import com.example.ui.components.CategorySelectorRow
import com.example.ui.components.FavoritesBottomSheet
import com.example.ui.components.RomanticHeroCard
import com.example.ui.theme.PlayfairDisplayFontFamily
import com.example.ui.theme.RoseCrimson
import com.example.ui.viewmodel.RomanticViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyRomanticScreen(
    viewModel: RomanticViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val currentStatus by viewModel.currentStatus.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val isGenerating by viewModel.isGenerating.collectAsStateWithLifecycle()
    val generationHint by viewModel.generationHint.collectAsStateWithLifecycle()
    val favorites by viewModel.favorites.collectAsStateWithLifecycle()
    val includeHashtags by viewModel.includeHashtags.collectAsStateWithLifecycle()
    val toastMessage by viewModel.toastMessage.collectAsStateWithLifecycle()
    val showFavoritesSheet by viewModel.showFavoritesSheet.collectAsStateWithLifecycle()
    val showAboutDialog by viewModel.showAboutDialog.collectAsStateWithLifecycle()
    val showCardShareDialog by viewModel.showCardShareDialog.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(toastMessage) {
        toastMessage?.let { msg ->
            snackbarHostState.showSnackbar(msg)
            viewModel.clearToastMessage()
        }
    }

    val todayDateFormatted = remember {
        val today = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("EEEE, MMM d", Locale.getDefault())
        today.format(formatter)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Daily Romantic Status",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontFamily = PlayfairDisplayFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 21.sp
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "$todayDateFormatted • Free Daily Quotes",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    // Favorites Button
                    IconButton(
                        onClick = { viewModel.openFavorites() },
                        modifier = Modifier.testTag("action_favorites_button")
                    ) {
                        BadgedBox(
                            badge = {
                                if (favorites.isNotEmpty()) {
                                    Badge(
                                        containerColor = RoseCrimson,
                                        contentColor = MaterialTheme.colorScheme.onPrimary
                                    ) {
                                        Text("${favorites.size}")
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "View saved favorites",
                                tint = if (favorites.isNotEmpty()) RoseCrimson else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // About / Info Button
                    IconButton(
                        onClick = { viewModel.openAbout() },
                        modifier = Modifier.testTag("action_about_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About and app license info",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                BannerAdContainer()
            }
        }
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.TopCenter
        ) {
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Category Filter Row
                CategorySelectorRow(
                    selectedCategory = selectedCategory,
                    onCategorySelected = { viewModel.selectCategory(it) }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Hero Status Card
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    RomanticHeroCard(
                        status = currentStatus,
                        isGenerating = isGenerating,
                        includeHashtags = includeHashtags,
                        onCopy = { viewModel.copyToClipboard(context, currentStatus) },
                        onShare = { viewModel.shareStatus(context, currentStatus) },
                        onToggleFavorite = { viewModel.toggleFavorite(currentStatus) },
                        onCardView = { viewModel.openCardShare() }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Primary Craft / Generate Action Button
                    Button(
                        onClick = { viewModel.generateNext() },
                        enabled = !isGenerating,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("generate_next_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        if (isGenerating) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = MaterialTheme.colorScheme.onPrimary,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = generationHint,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (selectedCategory == RomanticCategory.ALL) "Craft Another Status" else "Craft Next in ${selectedCategory.displayName}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Secondary Tools Row: Hashtag inclusion toggle
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FilterChip(
                            selected = includeHashtags,
                            onClick = { viewModel.toggleIncludeHashtags() },
                            label = {
                                Text(
                                    text = if (includeHashtags) "Hashtags Included" else "+ Add Social Hashtags",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            leadingIcon = if (includeHashtags) {
                                {
                                    Icon(
                                        imageVector = Icons.Outlined.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            } else null,
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.testTag("hashtag_toggle_chip")
                        )

                        Text(
                            text = "100% Offline • Instant Copy",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Quick Guide / Tips Card
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "💡 Quick Sharing Tip",
                                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Tap 'Copy' to paste anywhere, or tap 'Share' to post directly to WhatsApp Status, Facebook Story, or Instagram Caption in one tap.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }

    // Favorites Bottom Sheet
    if (showFavoritesSheet) {
        FavoritesBottomSheet(
            favorites = favorites,
            onDismiss = { viewModel.closeFavorites() },
            onCopy = { viewModel.copyToClipboard(context, it) },
            onShare = { viewModel.shareStatus(context, it) },
            onRemoveFavorite = { viewModel.toggleFavorite(it) }
        )
    }

    // Card View Dialog
    if (showCardShareDialog) {
        CardShareDialog(
            status = currentStatus,
            onDismiss = { viewModel.closeCardShare() },
            onCopy = {
                viewModel.copyToClipboard(context, currentStatus)
                viewModel.closeCardShare()
            },
            onShare = {
                viewModel.shareStatus(context, currentStatus)
                viewModel.closeCardShare()
            }
        )
    }

    // About Dialog
    if (showAboutDialog) {
        AboutDialog(
            onDismiss = { viewModel.closeAbout() }
        )
    }
}
