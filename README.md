# 📱 QuickCalc Android Application

<div align="center">

![Platform](https://img.shields.io/badge/Platform-Android_API_24+-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-Material_3-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-FF6F00?style=for-the-badge)
[![Android CI](https://github.com/ritikthakur22/QuickCalc/actions/workflows/android.yml/badge.svg)](https://github.com/ritikthakur22/QuickCalc/actions/workflows/android.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

<p align="center">
  A modern, high-performance Android calculator application built from the ground up using <b>Kotlin</b>, <b>Jetpack Compose</b>, and <b>MVVM Architecture</b>.
</p>

[Key Features](#-key-features) •
[Architecture](#-architecture--tech-stack) •
[Project Structure](#-project-structure) •
[Getting Started](#-getting-started--build-guide) •
[License](#-license) •
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
* **📱 Decimal Soft-Keyboard Support:** Native `KeyboardType.Decimal` keyboard binding for rapid decimal numbers and touch-friendly operand entry.
* **🧹 One-Click Clear Action:** Instant "Clear All" state reset returning inputs and calculation message back to initial state.
* **🧪 100% Test-Covered ViewModel:** Comprehensive unit test suite with JUnit 4 covering arithmetic rules, boundaries, and resets.

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
├── .github/
│   └── workflows/
│       └── android.yml                      # CI workflow: Unit testing & release APK build
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml          # Application manifest & entry point
│   │   │   └── java/com/example/quickcalc/
│   │   │       ├── MainActivity.kt          # UI layer: ComponentActivity & CalculatorScreen
│   │   │       ├── MainViewModel.kt         # Logic layer: State management & calculation lambdas
│   │   │       └── ui/theme/
│   │   │           ├── Color.kt             # Material 3 custom color definitions
│   │   │           └── Theme.kt             # Application theme wrapper & color schemes
│   │   └── test/
│   │       └── java/com/example/quickcalc/
│   │           └── MainViewModelTest.kt     # JUnit 4 unit test suite
│   ├── build.gradle.kts                     # App-level build config, SDK levels & dependencies
│   └── proguard-rules.pro                   # Code shrinking and obfuscation rules
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar               # Gradle wrapper executable
│       └── gradle-wrapper.properties        # Gradle version distribution configuration
├── .gitignore                               # Android Studio & Gradle ignore rules
├── build.gradle.kts                         # Root project build configuration
├── gradle.properties                        # Gradle JVM & build settings
├── gradlew                                  # Unix/macOS Gradle wrapper script
├── gradlew.bat                              # Windows Gradle wrapper batch script
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

### Option 1: Build with Android Studio (Recommended)

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
4. **Generate Release APK:**
   * Go to **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
   * Locate the generated APK at `app/build/outputs/apk/release/app-release.apk`.

### Option 2: Build & Test via Command Line (Gradle Wrapper)

* **Run all Unit Tests:**
  ```bash
  ./gradlew test
  ```
* **Assemble Release APK:**
  ```bash
  ./gradlew assembleRelease
  ```
  The compiled APK will be at:
  ```text
  app/build/outputs/apk/release/app-release.apk
  ```

### Option 3: Download Pre-built Release APK from GitHub Actions

Every push to `main` automatically runs our CI pipeline and compiles a signed Release APK artifact.
1. Navigate to the [Actions tab](https://github.com/ritikthakur22/QuickCalc/actions).
2. Click on the latest workflow run.
3. Scroll down to **Artifacts** and download `QuickCalc-release-apk`.

---

## 📄 License

This project is open-source and distributed under the **[MIT License](LICENSE)**. Anyone is free to use, modify, adapt, and distribute this software with proper credit and attribution to the original author.

---

## 👨‍💻 Author & Contact

**Ritik Thakur**  
*Full-Stack & Mobile Developer*

* 🌐 **Portfolio:** [ritikthakur.com.np](https://www.ritikthakur.com.np/)
* 🐙 **GitHub:** [@ritikthakur22](https://github.com/ritikthakur22)
* 💼 **LinkedIn:** [/in/ritikthakur22](https://www.linkedin.com/in/ritikthakur22/)
* ✉️ **Email:** [contact@ritikthakur.com.np](mailto:contact@ritikthakur.com.np)
