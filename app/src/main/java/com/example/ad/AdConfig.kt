package com.example.ad

/**
 * Centralized AdMob Configuration for Daily Romantic Status.
 *
 * Configured with ViveScript Solutions LLC production ad units:
 * - App ID: ca-app-pub-5222053984568989~5680583880
 * - Banner 1: ca-app-pub-5222053984568989/2859724289
 * - Interstitial 1: ca-app-pub-5222053984568989/9233560948
 */
object AdConfig {
    /** Production AdMob App ID */
    const val APP_ID = "ca-app-pub-5222053984568989~5680583880"

    /** Production Banner Ad Unit ID (Banner 1) */
    const val BANNER_AD_UNIT_ID = "ca-app-pub-5222053984568989/2859724289"

    /** Production Interstitial Ad Unit ID (Interstitial 1) */
    const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-5222053984568989/9233560948"

    /** Google Official Test Banner ID (for local testing without invalid clicks) */
    const val TEST_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"

    /** Google Official Test Interstitial ID (for local testing) */
    const val TEST_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

    /**
     * Set to false to serve real production ads.
     * When true, serves Google's official test ads to protect account from policy flags during development.
     */
    var useTestAds: Boolean = false

    /** Global ad display toggle */
    const val ADS_ENABLED = true

    /**
     * Resolves active banner unit ID based on test mode setting.
     */
    val bannerAdUnitId: String
        get() = if (useTestAds) TEST_BANNER_AD_UNIT_ID else BANNER_AD_UNIT_ID

    /**
     * Resolves active interstitial unit ID based on test mode setting.
     */
    val interstitialAdUnitId: String
        get() = if (useTestAds) TEST_INTERSTITIAL_AD_UNIT_ID else INTERSTITIAL_AD_UNIT_ID
}
