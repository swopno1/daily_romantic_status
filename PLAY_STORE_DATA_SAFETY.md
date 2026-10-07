# Google Play Store Data Safety Questionnaire Guide

Application: **Daily Romantic Status**  
Package: `com.vivescriptsolutions.dailyromanticstatus`  
Publisher: **ViveScript Solutions LLC**

---

## 1. Overview Summary

The core functionality of Daily Romantic Status is **completely offline** and **does not collect or share any personal user data**. The only external service configured in the app is **Google AdMob** for banner ads.

---

## 2. Google Play Console Data Safety Form Responses

### Step 1: Data Collection and Security
* **Does your app collect or share any of the required user data types?**  
  👉 **Yes** *(Solely due to the presence of Google Mobile Ads SDK/AdMob)*
* **Is all of the user data collected by your app encrypted in transit?**  
  👉 **Yes** *(AdMob network traffic uses HTTPS)*
* **Do you provide a way for users to request that their data be deleted?**  
  👉 **Yes** *(Users can clear app cache/storage or uninstall the application to erase all local favorites immediately)*

---

### Step 2: Data Types Breakdown

#### Category: Location
* Approximate location / Precise location: **No**

#### Category: Personal Info
* Name, Email, User IDs, Address, Phone number, Race/Ethnicity, Political/Religious beliefs, Sexual orientation: **No**

#### Category: Financial Info
* Credit card, Bank details, Purchase history: **No**

#### Category: Health and Fitness
* Health or Fitness data: **No**

#### Category: Messages
* Emails, SMS, In-app messages: **No**

#### Category: Photos and Videos
* Photos, Videos: **No**

#### Category: Audio Files
* Voice recordings: **No**

#### Category: Files and Docs
* Files, documents: **No**

#### Category: Calendar
* Calendar events: **No**

#### Category: Contacts
* Contacts: **No**

#### Category: App Activity
* Page views, App interactions, In-app search history, Installed apps: **No**

#### Category: Web Browsing
* Web browsing history: **No**

#### Category: Device or Other IDs
* **Device or other IDs (e.g., Advertising ID for AdMob):**  
  👉 **Yes (Collected by AdMob)**
  * **Collected?** Yes
  * **Shared?** Yes (Shared with Google AdMob)
  * **Processed ephemerally?** No
  * **Is this data required or optional?** Required by AdMob SDK
  * **Purposes:**
    * ✅ Advertising or Marketing
    * ✅ Fraud prevention, security, and compliance

---

## 3. Privacy Policy URL

Use the official URL hosted on ViveScript Solutions website or repository:
`https://www.vivescriptsolutions.com/privacy-daily-romantic-status`
*(Or link directly to the repository's `PRIVACY_POLICY.md`)*
