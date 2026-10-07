package com.example.ad

/**
 * Centralized AdMob Configuration.
 *
 * Current State: Configured with official Google AdMob test IDs for development
 * and Play Store review verification.
 *
 * TO SWITCH TO PRODUCTION:
 * 1. Set [IS_TEST_ADS] = false
 * 2. Replace [BANNER_AD_UNIT_ID] with the production banner ad unit ID from your AdMob console.
 * 3. Update the `com.google.android.gms.ads.APPLICATION_ID` in AndroidManifest.xml.
 */
object AdConfig {
    /** Official Google AdMob Test App ID */
    const val TEST_APP_ID = "ca-app-pub-3940256099942544~3347511713"

    /** Official Google AdMob Test Banner Unit ID */
    const val TEST_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"

    /** Set to false when deploying with registered production AdMob keys */
    const val IS_TEST_ADS = true

    /** Global ad display toggle */
    const val ADS_ENABLED = true

    /**
     * Resolves the active banner unit ID based on current environment mode.
     */
    val bannerAdUnitId: String
        get() = if (IS_TEST_ADS) {
            TEST_BANNER_AD_UNIT_ID
        } else {
            // Production Ad Unit ID placeholder for ViveScript Solutions LLC
            "ca-app-pub-XXXXXXXXXXXXXXXX/YYYYYYYYYY"
        }
}
