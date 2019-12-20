package com.example.lenovo.tinkersample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {
    TextView tv_load_patch;
    TextView tv_load_library;
    TextView tv_clear_patch;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        askForRequiredPermissions();
        tv_load_patch = findViewById(R.id.tv_load_patch);
        tv_load_library = findViewById(R.id.tv_load_library);
        tv_clear_patch = findViewById(R.id.tv_clear_patch);
        tv_result = findViewById(R.id.tv_result);

        tv_load_patch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
            }
        });
    }
    private void askForRequiredPermissions() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
    }
    private boolean hasRequiredPermissions() {
        if (Build.VERSION.SDK_INT >= 16) {
            final int res = ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            return res == PackageManager.PERMISSION_GRANTED;
        } else {
            // When SDK_INT is below 16, READ_EXTERNAL_STORAGE will also be granted if WRITE_EXTERNAL_STORAGE is granted.
            final int res = ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return res == PackageManager.PERMISSION_GRANTED;
        }
    }

}
