# Changelog

All notable changes to **Daily Romantic Status** are documented in this file.

## [2.0.0] - 2026-10-07

### Added
- **Production Google AdMob Integration:** Integrated Google Mobile Ads SDK with App ID (`ca-app-pub-5222053984568989~5680583880`).
- **Banner Ad Placement:** Standard 320x50 Banner 1 ad unit (`ca-app-pub-5222053984568989/2859724289`) in bottom navigation-safe container.
- **Interstitial Ad Placement:** Interstitial 1 ad unit (`ca-app-pub-5222053984568989/9233560948`) managed by `InterstitialAdManager` with background preloading and policy-compliant frequency capping.
- **Version Bump:** Updated `versionCode` to 2 and `versionName` to 2.0.

## [1.0.0] - 2026-10-07

### Added
- **Initial Release:** Complete Android application built with Kotlin and Jetpack Compose.
- **Deterministic Daily Status Engine:** Seed-based daily romantic pick that stays consistent throughout each calendar day without server calls.
- **Rich Curated Library:** Over 100+ high-quality, tasteful romantic statuses across 6 mood categories (Sweet & Tender, Deep & Poetic, Playful & Cute, Morning & Night, Short & Bio, Long Distance).
- **Procedural AI-Style Combinator:** Algorithmic prompt synthesizer generating endless romantic caption variations on demand.
- **One-Tap Actions:** Instant Copy to clipboard with tactile snackbar feedback and native Android Share Sheet integration.
- **Offline Favorites Management:** Private local bookmarking of favorite quotes using `SharedPreferences`.
- **Social Story Card Preview:** Visual card dialog styled for Instagram Stories, WhatsApp status, and Facebook posts.
- **Editorial Typography:** Bundled Google Font *Playfair Display* for romantic serif display styling.
- **Centralized AdMob Architecture:** Isolated `AdConfig` containing official Google test IDs for seamless production swap.
- **Full Legal & Store Documentation:** MIT `LICENSE`, `PRIVACY_POLICY.md`, `TERMS_OF_SERVICE.md`, `PLAY_STORE_METADATA.md`, `PLAY_STORE_DATA_SAFETY.md`, and `DESIGN_ASSETS.md`.
