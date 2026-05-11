package com.hmdd.quickopen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun OpenAppsButton() {
    val context = LocalContext.current

    // القائمة المحدثة المطلوبة
    val appsToLaunch = listOf(
        "com.kiwibrowser.browser",
        "com.github.android",
        "com.google.android.apps.bard",
        "com.anthropic.claude",
        "com.deepseek.chat",
        "com.google.android.apps.nbu.files",
        "com.google.android.keep"
    )

    Button(onClick = {
        // استدعاء الدالة التي قمنا بتعريفها سابقاً
        launchMultipleApps(context, appsToLaunch)
    }) {
        Text("فتح التطبيقات المختارة")
    }
}
