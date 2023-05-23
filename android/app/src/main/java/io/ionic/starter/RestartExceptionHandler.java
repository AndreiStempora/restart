package io.ionic.starter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.app.AlarmManager;


public class RestartExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final Context context;

    public RestartExceptionHandler(Context context) {
        this.context = context;
    }

//     @Override
//     public void uncaughtException(Thread thread, Throwable throwable) {
        // Restart the app when an uncaught exception occurs
//         Intent intent = new Intent(context, MainActivity.class);
//         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//         context.startActivity(intent);
//
//         // Exit the current process
//         Process.killProcess(Process.myPid());
//         System.exit(2);
@Override
    public void uncaughtException(Thread thread, Throwable exception) {
        // Restart the application after 2 seconds
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, intent);
        }

        // Exit the current process
        System.exit(2);

    }
}