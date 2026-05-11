# QuickOpen

تطبيق Android Native مكتوب بـ Kotlin + Jetpack Compose، يفتح عدة تطبيقات بضغطة زر واحدة.

## التطبيقات المُستهدفة افتراضياً

- Kiwi Browser (`com.kiwibrowser.browser`)
- GitHub (`com.github.android`)
- Gemini (`com.google.android.apps.bard`)
- Claude (`com.anthropic.claude`)
- DeepSeek (`com.deepseek.chat`)
- Files by Google (`com.google.android.apps.nbu.files`)
- Google Keep (`com.google.android.keep`)

> لتعديل القائمة، حرّر `appsToLaunch` في الملف `app/src/main/java/com/hmdd/quickopen/OpenAppsButton.kt`.

## تحميل APK

بعد كل push على فرع `main` يقوم GitHub Actions ببناء APK تلقائياً، وتجده عبر:

1. **Releases** (مُستحسن): تبويب [Releases](../../releases) ← `latest` ← حمّل `QuickOpen-debug.apk`.
2. **Actions artifacts**: تبويب [Actions](../../actions) ← آخر run ناجح ← قسم *Artifacts* ← `QuickOpen-debug-apk`.

## ملاحظات تقنية

- **`QUERY_ALL_PACKAGES`**: التطبيق يستخدم هذه الصلاحية لرؤية التطبيقات المُثبَّتة (مطلوب على Android 11+ ليعمل `getLaunchIntentForPackage`). هذه الصلاحية مقيدة على Google Play، لكن لا مشكلة منها للاستخدام الشخصي / sideload.
- **minSdk = 24** (Android 7.0)، **targetSdk = 34** (Android 14).

## البناء محلياً

```bash
./gradlew assembleDebug
# APK في: app/build/outputs/apk/debug/app-debug.apk
```
