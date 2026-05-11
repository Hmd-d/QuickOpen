package com.hmdd.quickopen

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
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

    // بعد إطلاق كل التطبيقات: إغلاق QuickOpen وإزالته من قائمة Recent apps
    context.findActivity()?.finishAndRemoveTask()
}

/**
 * يستخرج الـ Activity من أي Context (قد يكون ملفوفاً بـ ContextWrapper كما يحدث في Compose).
 * يُرجع null إذا لم يُعثر على Activity في السلسلة.
 */
private fun Context.findActivity(): Activity? {
    var ctx: Context = this
    while (ctx is ContextWrapper) {
        if (ctx is Activity) return ctx
        ctx = ctx.baseContext
    }
    return null
}
