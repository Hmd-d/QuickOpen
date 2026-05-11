package com.hmdd.quickopen

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun launchMultipleApps(context: Context, packageNames: List<String>) {
    for (packageName in packageNames) {
        // محاولة الحصول على الـ Intent الخاص بتشغيل التطبيق
        val intent: Intent? = context.packageManager.getLaunchIntentForPackage(packageName)

        if (intent != null) {
            // إضافة هذا الـ Flag مهم جداً لفتح التطبيق في مهمة (Task) منفصلة
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } else {
            // في حال كان التطبيق غير مثبت على الجهاز
            Toast.makeText(context, "التطبيق $packageName غير متوفر", Toast.LENGTH_SHORT).show()
        }
    }
}
