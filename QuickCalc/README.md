# QuickCalc Android App

A simple calculator application built with Kotlin, Jetpack Compose, and MVVM Architecture.

## Features
- Two number input fields
- Basic arithmetic operations: Add, Subtract, Multiply, Divide
- Instant results handling and error displaying
- Pure Material Design 3 and Jetpack Compose

## How to Build the APK

1. **Using Android Studio (Recommended):**
   - Open Android Studio.
   - Select "Open" and navigate to this project's folder `QuickCalc`.
   - Wait for Gradle to sync automatically.
   - Click the "Run" button (green play icon) to build and install the debug APK on an emulator or connected device.
   - To generate a release APK, go to `Build > Generate Signed Bundle / APK...` and follow the wizard.

2. **Using Command Line (with Gradle):**
   - Ensure you have the Android SDK installed and `ANDROID_HOME` configured.
   - Since the Gradle wrapper scripts are not explicitly generated, ensure you have Gradle installed on your system or generate them first via IDE.
   - Open a terminal and navigate to the project root directory.
   - Run the command: `gradle assembleDebug`.
   - The compiled APK will be located at `app/build/outputs/apk/debug/app-debug.apk`.
