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

**QuickCalc** is a modern, full-featured Android calculator application engineered with **Kotlin**, **Jetpack Compose**, and **Material Design 3**. It features an interactive **5×4 tactile keypad grid**, real-time expression evaluation with live result preview, mathematical order of operations (BODMAS/PEMDAS), parentheses support, and a zero-crash recursive descent parsing engine.

---

## 🚀 Key Features

* **⚡ Pure Jetpack Compose UI:** 100% declarative UI built without legacy XML layouts or fragments.
* **⌨️ Full 5×4 Tactile Keypad:** Responsive, circular Material 3 buttons with distinct color coding for digits, operators, clear (`AC`), delete (`⌫`), and equals (`=`).
* **🔮 Real-Time Live Preview:** Evaluates calculations as you type — showing live answers instantly before pressing `=`.
* **🧠 True Order of Operations:** Evaluates standard mathematical expressions with correct operator precedence (`×` and `÷` before `+` and `−`).
* **📦 Parentheses Support `( )`:** Group sub-expressions with automatic open/close matching for complex formulas.
* **💯 Percentage Calculations `%`:** Quick percentage operations with a single tap.
* **🛡️ Zero-Crash Error Protection:** Guarded division-by-zero protection (`Cannot divide by zero`) without application crashes.
* **🔢 Smart Decimal Formatting:** Prevents duplicate decimal dots and formats whole numbers cleanly without trailing `.0`.
* **🧪 100% Tested Parsing Engine:** Dedicated JUnit 4 test suite verifying arithmetic rules, operator precedence, and edge cases.

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
│   │   │       ├── MainActivity.kt          # UI layer: ComponentActivity & CalculatorScreen (5x4 Keypad)
│   │   │       ├── MainViewModel.kt         # Logic layer: State management & user event handling
│   │   │       ├── ExpressionEvaluator.kt   # Math engine: Recursive descent parser & precedence
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

### Option 3: Download Pre-built Release APK

You can download the pre-compiled, signed Release APK directly:
* ⬇️ **[Download QuickCalc v1.2 Release APK](https://github.com/ritikthakur22/QuickCalc/releases)**
* Or download from the latest run in the **[GitHub Actions tab](https://github.com/ritikthakur22/QuickCalc/actions)** under Artifacts (`QuickCalc-v1.2-release-apk`).

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
