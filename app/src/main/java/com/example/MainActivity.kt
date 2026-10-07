package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ad.InterstitialAdManager
import com.example.ui.DailyRomanticScreen
import com.example.ui.theme.DailyRomanticStatusTheme
import com.example.ui.viewmodel.RomanticViewModel
import com.google.android.gms.ads.MobileAds

class MainActivity : ComponentActivity() {

    private val viewModel: RomanticViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Google Mobile Ads SDK
        MobileAds.initialize(this) {
            // Preload the first interstitial ad as soon as SDK is initialized
            InterstitialAdManager.loadAd(this)
        }

        setContent {
            DailyRomanticStatusTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DailyRomanticScreen(
                        viewModel = viewModel,
                        onTriggerCraftAd = { onDone ->
                            InterstitialAdManager.onUserCraftAction(this, onDone)
                        }
                    )
                }
            }
        }
    }
}
