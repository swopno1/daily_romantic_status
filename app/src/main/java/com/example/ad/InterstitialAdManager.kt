package com.example.ad

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

/**
 * Manages loading and displaying AdMob Interstitial Ads in compliance with Google AdMob policies:
 * - Preloads ads in the background
 * - Prevents showing unexpected ads during active typing or app launch
 * - Provides graceful callbacks so user flow is never blocked
 * - Automatically reloads the next interstitial upon dismissal
 */
object InterstitialAdManager {
    private const val TAG = "InterstitialAdManager"

    private var interstitialAd: InterstitialAd? = null
    private var isLoading = false
    private var craftCounter = 0

    // Threshold of user actions (e.g. status generations) before showing interstitial
    private const val CRAFT_THRESHOLD = 3

    /**
     * Initializes and preloads the first interstitial ad.
     */
    fun loadAd(context: Context) {
        if (!AdConfig.ADS_ENABLED || isLoading || interstitialAd != null) return

        isLoading = true
        val adRequest = AdRequest.Builder().build()
        val adUnitId = AdConfig.interstitialAdUnitId

        InterstitialAd.load(
            context.applicationContext,
            adUnitId,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isLoading = false
                    Log.d(TAG, "Interstitial ad loaded successfully.")
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                    isLoading = false
                    Log.w(TAG, "Interstitial ad failed to load: ${loadAdError.message}")
                }
            }
        )
    }

    /**
     * Increments the user craft/generation count and displays an interstitial ad
     * once the threshold is reached, in accordance with AdMob policy guidelines.
     */
    fun onUserCraftAction(activity: Activity, onCompleted: () -> Unit = {}) {
        craftCounter++
        if (craftCounter >= CRAFT_THRESHOLD && isAdReady()) {
            craftCounter = 0
            showAd(activity, onCompleted)
        } else {
            onCompleted()
        }
    }

    /**
     * Checks if an interstitial ad is loaded and ready.
     */
    fun isAdReady(): Boolean = interstitialAd != null

    /**
     * Displays the interstitial ad if available, then triggers the callback.
     */
    fun showAd(activity: Activity, onDismissedOrFailed: () -> Unit = {}) {
        val ad = interstitialAd
        if (ad != null) {
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Interstitial ad dismissed.")
                    interstitialAd = null
                    loadAd(activity)
                    onDismissedOrFailed()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.w(TAG, "Interstitial ad failed to show: ${adError.message}")
                    interstitialAd = null
                    loadAd(activity)
                    onDismissedOrFailed()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Interstitial ad showed full screen.")
                }
            }
            ad.show(activity)
        } else {
            // Not ready yet; load for next time and continue immediately
            loadAd(activity)
            onDismissedOrFailed()
        }
    }
}
