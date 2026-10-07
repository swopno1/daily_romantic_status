# Daily Romantic Status

[![Platform: Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Language: Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg)](https://kotlinlang.org)
[![UI: Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-blue.svg)](https://developer.android.com/jetpack/compose)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**Daily Romantic Status** is a lightweight, privacy-focused Android application designed for users who want fresh, emotionally captivating romantic captions and posts for WhatsApp, Facebook, Instagram, or messaging without spending time writing one themselves.

Published and developed by **ViveScript Solutions LLC**.

---

## 🌟 Overview

* **App Name:** Daily Romantic Status
* **Package Name:** `com.vivescriptsolutions.dailyromanticstatus`
* **Company:** ViveScript Solutions LLC
* **Website:** [https://www.vivescriptsolutions.com/](https://www.vivescriptsolutions.com/)
* **Primary Language:** English (with universal cultural resonance)
* **Target Audience:** Anyone seeking heartfelt, poetic, playful, or aesthetic romantic statuses and captions.

---

## 📱 Screenshots

| Today's Pick | Mood Filter | Favorites Sheet | Card Share Dialog |
|:---:|:---:|:---:|:---:|
| *(Main Screen Hero Card)* | *(Sweet, Poetic, Flirty)* | *(Saved Love Quotes)* | *(Social Media Post Card)* |

---

## ✨ Features

1. **Daily Curated Pick:** Deterministic, seed-based daily status updated automatically every midnight with zero server requests required.
2. **On-Demand AI-Style Crafting:** Procedural combinator engine synthesizes infinite fresh romantic variations combining lyrical hooks, emotional cores, and poetic signatures.
3. **6 Mood Categories:**
   * 💖 **Sweet & Tender:** Warm affection, gratitude, gentle romantic moments.
   * 🌹 **Deep & Poetic:** Soulful, lyrical, emotional reflections.
   * 💫 **Playful & Cute:** Charming, lighthearted, smile-inducing lines.
   * 🌙 **Morning & Night:** Wake-up wishes and cozy goodnight thoughts.
   * 💌 **Short & Bio:** Punchy one-liners (< 120 chars) perfect for WhatsApp Status and Instagram bios.
   * ✈️ **Long Distance:** Heartfelt devotion across the miles.
4. **One-Tap Actions:**
   * **Copy to Clipboard:** Instant copy with tactile snackbar feedback.
   * **Native Share Sheet:** Direct sharing to WhatsApp, Instagram, Facebook, SMS, or Telegram.
   * **Favorites Bookmark:** Save cherished quotes offline for instant retrieval.
   * **Social Card Preview:** Elegant visual preview styled for Instagram Stories and social posts.
5. **Hashtag Generator Toggle:** One-tap option to append relevant romantic hashtags (`#Love #Soulmate #RomanticStatus`).
6. **100% Offline & Private:** Requires zero login, zero accounts, and zero sensitive permissions.

---

## 🛠 Technology Stack

* **Kotlin:** Modern, type-safe language.
* **Jetpack Compose:** Modern declarative UI with Material Design 3.
* **AndroidX & Lifecycle:** ViewModel + StateFlow + coroutines.
* **Playfair Display Font:** Locally bundled Google Font in `res/font/` for elegant editorial typography.
* **Google AdMob:** Official test configuration isolated in `AdConfig.kt`.

---

## 📋 System Requirements

* **Minimum SDK:** Android 7.0 (API Level 24)
* **Target SDK:** Android 16 (API Level 36)
* **JDK Version:** Java 11+
* **Build Tool:** Gradle with Kotlin DSL (`.gradle.kts`)

---

## 🚀 Installation & Build

### 1. Clone Repository
```bash
git clone https://github.com/vivescriptsolutions/daily-romantic-status.git
cd daily-romantic-status
```

### 2. Open in Android Studio
* Open Android Studio Ladybug or later.
* Select **File > Open** and choose the project root folder.
* Allow Gradle to sync dependencies automatically.

### 3. Build & Run
* Run on a connected device or emulator:
  ```bash
  gradle assembleDebug
  ```
* Run unit tests:
  ```bash
  gradle testDebugUnitTest
  ```

---

## 📁 Project Structure

```text
app/src/main/
├── AndroidManifest.xml          # App manifest & AdMob test configuration
├── java/com/example/
│   ├── MainActivity.kt          # Single-Activity entry point
│   ├── ad/
│   │   ├── AdConfig.kt          # Centralized AdMob test & production IDs
│   │   └── BannerAdView.kt      # Responsive ad banner container
│   ├── data/
│   │   ├── RomanticContentEngine.kt # Curated statuses & AI-style combinator
│   │   └── FavoritesRepository.kt   # Offline SharedPreferences persistence
│   ├── model/
│   │   ├── RomanticCategory.kt  # 6 curated mood categories
│   │   └── RomanticStatus.kt    # Data model and tag formatter
│   └── ui/
│       ├── DailyRomanticScreen.kt   # Core single-screen interface
│       ├── components/
│       │   ├── AboutDialog.kt       # Publisher, license, & privacy dialog
│       │   ├── CardShareDialog.kt   # Story/quote card preview dialog
│       │   ├── CategorySelectorRow.kt # Horizontal mood chips
│       │   ├── FavoritesBottomSheet.kt # Saved quotes management
│       │   └── RomanticHeroCard.kt  # Primary status card with actions
│       ├── theme/
│       │   ├── Color.kt             # Crimson & Rose romance palette
│       │   ├── Theme.kt             # Material 3 light & dark theme
│       │   └── Type.kt              # Playfair Display typography
│       └── viewmodel/
│           └── RomanticViewModel.kt # State management & UI orchestration
└── res/
    ├── font/playfair_display.ttf    # Bundled luxury serif font
    ├── mipmap-*/ic_launcher.png     # Custom adaptive launcher icons
    └── values/strings.xml           # Localized string resources
```

---

## 🔒 Privacy & Data Safety

* **No Personal Data Collected:** The app does not collect, transmit, or store names, emails, contacts, location, or device identifiers.
* **No Account Required:** Ready to use immediately upon installation.
* **Offline-First:** All content is generated locally on your device.
* **Advertising:** Google AdMob is integrated using Google Mobile Ads SDK with ViveScript Solutions LLC production App ID and ad unit placements (Banner 1 and Interstitial 1), adhering strictly to Google AdMob placement policies.

---

## 📜 Licensing & Copyright

* **Source Code:** Released under the [MIT License](LICENSE).
* **Proprietary Notice:**
  > © 2026 ViveScript Solutions LLC. The app name, logo, icons, screenshots, trademarks, and associated branding are proprietary property of ViveScript Solutions LLC and are not licensed under the MIT License.
