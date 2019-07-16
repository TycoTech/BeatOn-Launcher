package com.gyrojoe.oculustvlauncher.appstarter;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import beat.tycotech.beaton.R;

public class MainActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.target_package);
        PackageManager packageManager = getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(string);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(string);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(new ComponentName("com.oculus.vrshell", "com.oculus.vrshell.MainActivity"));
        intent.setData(Uri.parse("com.oculus.tv"));
        intent.putExtra("uri", launchIntentForPackage.getComponent().flattenToString());
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        finish();
    }
}
