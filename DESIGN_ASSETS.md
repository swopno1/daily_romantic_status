# Design Assets & Graphics Specification — Daily Romantic Status

Publisher: **ViveScript Solutions LLC**  
Brand Identity: **Daily Romantic Status**  
Copyright: © 2026 ViveScript Solutions LLC. All rights reserved.

---

## 1. Brand Visual Identity

### Color Palette
* **Brand Primary (Deep Crimson):** `#831843` / `#BE123C` (Symbolizes timeless romance and elegance)
* **Secondary (Rose Soft):** `#FB7185` (Warm accent for heart badges and highlights)
* **Background Light:** `#FFF8F9` (Clean, warm ivory-blush surface)
* **Background Dark:** `#1F0811` (Luxury night wine tone for dark theme)
* **Text High Contrast:** `#4C0519` (Light mode) / `#FFF1F2` (Dark mode)

### Typography
* **Display / Quotes:** *Playfair Display* (Editorial luxury serif bundled in `res/font/playfair_display.ttf`)
* **UI & Controls:** Material Design System Font (clean, high legibility)

---

## 2. Google Play Store Graphics Catalog

All production graphic assets have been generated, sized, and saved into the `store_assets/` folder ready for direct upload to Google Play Console:

### 2.1 High-Resolution App Icon (512 × 512 px)
* **Path:** `store_assets/icon/app_icon_512x512.png`
* **Format:** 32-bit PNG with alpha
* **Dimensions:** 512 × 512 px
* **Visual:** Glowing romantic heart intertwined with sparkles and feather quill on a solid `#831843` crimson background.

### 2.2 Google Play Feature Graphic (1024 × 500 px)
* **Path:** `store_assets/feature_graphic/feature_graphic_1024x500.png`
* **Format:** 24-bit PNG (no alpha)
* **Dimensions:** 1024 × 500 px
* **Visual:** Deep crimson gradient background with glowing 3D heart, golden sparkles, and luxury card banner reading *“Daily Romantic Status — Express Love Effortlessly”*.

### 2.3 Mobile Phone Screenshots (1080 × 1920 px, 9:16 Portrait)
* **Screenshot 1 (Hero / Today's Pick):**
  * **Path:** `store_assets/screenshots/mobile/screenshot_1_hero_1080x1920.png`
  * **Visual:** Main screen with today's featured romantic status, quotation marks, date header, and Copy/Share buttons.
* **Screenshot 2 (Categories & AI Craft):**
  * **Path:** `store_assets/screenshots/mobile/screenshot_2_categories_1080x1920.png`
  * **Visual:** Mood filter chips (Sweet, Poetic, Flirty, Morning & Night), "Craft Another Status" action button, and trending hashtags.
* **Screenshot 3 (Saved Favorites & Social Story Card):**
  * **Path:** `store_assets/screenshots/mobile/screenshot_3_favorites_1080x1920.png`
  * **Visual:** Offline Saved Favorites sheet with bookmarked love quotes and social media story card preview.

### 2.4 Tablet Screenshots (7-inch & 10-inch)
* **Tablet 10-inch (1920 × 1440 px):**
  * **Path:** `store_assets/screenshots/tablet/screenshot_tablet_10inch_1920x1440.png`
  * **Visual:** High-resolution expanded landscape layout showing responsive romantic card presentation and mood navigation.
* **Tablet 7-inch (1280 × 800 px):**
  * **Path:** `store_assets/screenshots/tablet/screenshot_tablet_7inch_1280x800.png`
  * **Visual:** 7-inch tablet layout optimized for compact tablets and foldables.

---

## 3. In-App Android Adaptive Launcher Icons

Configured inside `app/src/main/res/`:
* `res/drawable/ic_launcher_background.xml` (Solid `#831843`)
* `res/drawable/ic_launcher_foreground.xml` (Centered 66dp within 108dp canvas)
* `res/mipmap-mdpi/ic_launcher.png` & `ic_launcher_round.png` (48 × 48 px)
* `res/mipmap-hdpi/ic_launcher.png` & `ic_launcher_round.png` (72 × 72 px)
* `res/mipmap-xhdpi/ic_launcher.png` & `ic_launcher_round.png` (96 × 96 px)
* `res/mipmap-xxhdpi/ic_launcher.png` & `ic_launcher_round.png` (144 × 144 px)
* `res/mipmap-xxxhdpi/ic_launcher.png` & `ic_launcher_round.png` (192 × 192 px)

---

## 4. Verification & Status Checklist

- [x] 512×512 PNG app icon generated in `store_assets/icon/`
- [x] 1024×500 PNG feature graphic generated in `store_assets/feature_graphic/`
- [x] 3 Mobile screenshots (1080×1920) generated in `store_assets/screenshots/mobile/`
- [x] 2 Tablet screenshots (10-inch and 7-inch) generated in `store_assets/screenshots/tablet/`
- [x] Adaptive icon XMLs and mipmap rasters present in `app/src/main/res/`
