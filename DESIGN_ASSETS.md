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

## 2. App Launcher Icon

### Specifications
* **Adaptive Canvas Size:** 108dp × 108dp
* **Safe Zone:** 66dp diameter centered
* **Background Layer:** Solid `#831843` (`ic_launcher_background.xml`)
* **Foreground Layer:** Glowing romantic heart & feather quill symbol (`ic_launcher_foreground.xml`)
* **Raster Fallbacks:**
  * `mipmap-mdpi`: 48 × 48 px (PNG32)
  * `mipmap-hdpi`: 72 × 72 px (PNG32)
  * `mipmap-xhdpi`: 96 × 96 px (PNG32)
  * `mipmap-xxhdpi`: 144 × 144 px (PNG32)
  * `mipmap-xxxhdpi`: 192 × 192 px (PNG32)
  * High-res Play Store Icon: 512 × 512 px 32-bit PNG with alpha

---

## 3. Google Play Store Feature Graphic

* **Required Dimensions:** **1024 px width × 500 px height**
* **File Format:** 24-bit PNG or JPEG (no alpha)
* **File Size Limit:** 1 MB
* **Visual Composition:**
  * **Background:** Deep crimson wine gradient (`#831843` to `#4C0519`) with soft sparkling celestial stars.
  * **Focal Element (Left/Center):** Glowing 3D floating quote card displaying:  
    *“In a room full of art, I would still stare at you.”* in elegant *Playfair Display* typography.
  * **Badge:** Rounded pill reading: *“Daily Romantic Status”* with subtle gold border.
  * **Tagline:** *“Fresh Romantic Posts & Captions Every Single Day”*
  * **Company Watermark:** *ViveScript Solutions LLC* in bottom-right corner.

---

## 4. Google Play Store Screenshots Plan

### Dimensions
* **Standard Phone:** 1080 × 2400 px (9:16 portrait)
* Minimum 4 screenshots covering the critical user journey:

### Screenshot 1: Today’s Pick (Hero Screen)
* **Headline:** *"Today's Love Post, Ready in Seconds"*
* **Visual:** Main screen with today's featured romantic status, date header, and highlighted "Copy" button.

### Screenshot 2: 6 Mood Categories
* **Headline:** *"Find the Right Words for Every Feeling"*
* **Visual:** Category chips highlighted (Sweet & Tender, Deep & Poetic, Playful & Cute, Morning & Night, Long Distance).

### Screenshot 3: One-Tap Copy & Share
* **Headline:** *"Copy & Share Directly to WhatsApp & Instagram"*
* **Visual:** Action buttons with tactile feedback toast and active system share sheet preview.

### Screenshot 4: Saved Favorites
* **Headline:** *"Keep Your Favorite Quotes Forever"*
* **Visual:** The offline Saved Favorites sheet showing customized bookmarked quotes.

### Screenshot 5: Social Card Preview
* **Headline:** *"Aesthetic Cards for Instagram Stories"*
* **Visual:** The story card modal preview with elegant dark crimson typography.

---

## 5. Export & Asset Checklist

- [x] Adaptive icon foreground & background XMLs configured in `app/src/main/res/drawable/`
- [x] Raster launcher PNGs generated for mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi
- [x] Round launcher PNGs generated with circular transparency masking
- [x] Default template `.webp` launcher files removed
- [x] Bundled Google Font `playfair_display.ttf` installed in `res/font/`
