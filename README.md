# 📱 QuickCalc Android Application

<div align="center">

![Platform](https://img.shields.io/badge/Platform-Android_API_24+-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-Material_3-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-FF6F00?style=for-the-badge)
![License](https://img.shields.io/badge/License-All_Rights_Reserved-red?style=for-the-badge)

<p align="center">
  A modern, high-performance Android calculator application built from the ground up using <b>Kotlin</b>, <b>Jetpack Compose</b>, and <b>MVVM Architecture</b>.
</p>

[Key Features](#-key-features) •
[Architecture](#-architecture--tech-stack) •
[Project Structure](#-project-structure) •
[Getting Started](#-getting-started--build-guide) •
[License Policy](#-license--proprietary-notice) •
[Author](#-author--contact)

</div>

---

## 🌟 Overview

**QuickCalc** is a streamlined Android arithmetic utility that demonstrates best practices in modern Android development. Built with pure declarative UI via **Jetpack Compose** and Google's **Material Design 3**, it decouples UI logic from computation through a reactive **ViewModel** architecture, providing instant calculations, robust error handling, and zero-crash arithmetic boundaries.

---

## 🚀 Key Features

* **⚡ Pure Jetpack Compose UI:** 100% declarative UI built without XML layouts or legacy fragments.
* **🎨 Material Design 3 (M3):** Modern elevated card containers, dynamic color palettes, rounded action buttons, and responsive typography.
* **📐 Reactive MVVM Architecture:** Unidirectional data flow (UDF) powered by `MainViewModel` and Compose runtime state delegates (`mutableStateOf`).
* **🛡️ Zero-Crash Error Protection:**
  * Arithmetic exception boundary guarding against zero-division (`÷ 0`).
  * Real-time number validation checking for invalid numerical formats and empty inputs.
* **🔢 Smart Decimal Formatting:** Intelligently truncates unnecessary floating-point zeroes (e.g., displaying `25` instead of `25.0`) while preserving exact precision for fractional results (e.g., `3.14159`).
* **📱 Adaptive Keyboard Handling:** Numeric soft-input keyboard binding for rapid, touch-friendly operand entry.

---

## 🏗️ Architecture & Tech Stack

### Architecture Overview

QuickCalc adopts the recommended Android **MVVM (Model-View-ViewModel)** architectural pattern:

```
┌────────────────────────────────┐
│      CalculatorScreen (UI)     │ ◄── Pure Jetpack Compose UI Layer
│      (MainActivity.kt)         │
└───────────────┬────────────────┘
                │ User Inputs / Events (Add, Subtract, etc.)
                ▼
┌────────────────────────────────┐
│         MainViewModel          │ ◄── Business Logic & State Holder
│      (MainViewModel.kt)        │
└───────────────┬────────────────┘
                │ State Emissions (number1, number2, resultMessage)
                ▼
┌────────────────────────────────┐
│        Compose State UI        │ ◄── Automatically recomposes UI on state change
└────────────────────────────────┘
```

### Technical Specifications

| Component | Technology | Version / Specification |
| :--- | :--- | :--- |
| **Language** | Kotlin | `1.9.0` |
| **UI Framework** | Jetpack Compose (Compose BOM) | `2023.10.01` |
| **Design System** | Material Design 3 (`material3`) | Material 3 Components |
| **Target SDK** | Android SDK 34 | Android 14 (Upside Down Cake) |
| **Minimum SDK** | Android SDK 24 | Android 7.0 (Nougat) |
| **Build System** | Gradle Kotlin DSL | `build.gradle.kts` |
| **Compatibility** | JVM Target 1.8 | Java 8 Bytecode compatibility |

---

## 📂 Project Structure

```text
QuickCalc/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml          # Application manifest & entry point
│   │       └── java/com/example/quickcalc/
│   │           ├── MainActivity.kt          # UI layer: ComponentActivity & CalculatorScreen
│   │           ├── MainViewModel.kt         # Logic layer: State management & calculation lambdas
│   │           └── ui/theme/
│   │               ├── Color.kt             # Material 3 custom color definitions
│   │               └── Theme.kt             # Application theme wrapper & color schemes
│   ├── build.gradle.kts                     # App-level build config, SDK levels & dependencies
│   └── proguard-rules.pro                   # Code shrinking and obfuscation rules
├── .gitignore                               # Android Studio & Gradle ignore rules
├── build.gradle.kts                         # Root project build configuration
├── gradle.properties                        # Gradle JVM & build settings
├── LICENSE                                  # Proprietary copyright license
├── README.md                                # Project documentation
└── settings.gradle.kts                      # Module management and repository sources
```

---

## 🛠️ Getting Started & Build Guide

### Prerequisites
* **Android Studio** (Hedgehog 2023.1.1 or newer recommended)
* **Android SDK** API 34 installed
* **Java Development Kit (JDK)** 17 (bundled with modern Android Studio)

### Build with Android Studio (Recommended)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ritikthakur22/QuickCalc.git
   ```
2. **Open in Android Studio:**
   * Open Android Studio &rarr; Click **File > Open...** &rarr; Select the `QuickCalc` folder.
   * Allow Gradle to download dependencies and sync the project.
3. **Run on Device or Emulator:**
   * Connect an Android device (with USB Debugging enabled) or start an Android Emulator.
   * Click the green **Run (`Shift + F10`)** button in Android Studio toolbar.
4. **Generate Release / Debug APK:**
   * Go to **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
   * Locate the generated APK at:
     ```text
     app/build/outputs/apk/debug/app-debug.apk
     ```

---

## 🔒 License & Proprietary Notice

> **All Rights Reserved**  
> Copyright &copy; 2026 Ritik Thakur.

This repository, its source code, UI architectures, and design assets are the **confidential and proprietary property of Ritik Thakur**.

* **No License Granted:** No permission, authorization, or license (open-source or otherwise) is granted to copy, replicate, modify, distribute, publish, or use this source code without express prior written consent.
* **Educational / Demonstration Access:** If this repository is configured as publicly accessible on GitHub, it is presented strictly for code inspection and portfolio evaluation by prospective employers and recruiters. Forking, commercializing, or redistributing this application without authorization is prohibited.
* For the full legal text, review the [LICENSE](LICENSE) file.

---

## 👨‍💻 Author & Contact

**Ritik Thakur**  
*Full-Stack & Mobile Developer*

* 🌐 **Portfolio:** [ritikthakur.com.np](https://www.ritikthakur.com.np/)
* 🐙 **GitHub:** [@ritikthakur22](https://github.com/ritikthakur22)
* 💼 **LinkedIn:** [/in/ritikthakur22](https://www.linkedin.com/in/ritikthakur22/)
* ✉️ **Email:** [contact@ritikthakur.com.np](mailto:contact@ritikthakur.com.np)
