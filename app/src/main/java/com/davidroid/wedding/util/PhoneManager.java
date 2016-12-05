package com.davidroid.wedding.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.CALL_PHONE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

/**
 * Created by davidmartin on 5/12/16.
 */

public class PhoneManager {

    private static final int PERMISSIONS_REQUEST_FOR_PHONE_CALL = 1;

    private Activity activity;

    public PhoneManager(Activity activity) {
        this.activity = activity;
    }

    public void phoneTo(String phone) {
        if (hasPermissionForCallPhone()) {
            try {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone));
                activity.startActivity(callIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            requestPermissionForCallPhone();
        }
    }

    private void requestPermissionForCallPhone() {
        requestPermissionsFor(PERMISSIONS_REQUEST_FOR_PHONE_CALL, CALL_PHONE);
    }

    private boolean hasPermissionForCallPhone() {
        return hasPermissionFor(CALL_PHONE);
    }

    private boolean hasPermissionFor(String permission) {
        return PERMISSION_GRANTED == ContextCompat.checkSelfPermission(activity.getApplicationContext(), permission);
    }

    private void requestPermissionsFor(int requestCode, String... permissions) {

        List<String> permissionsList = new ArrayList<>();

        for (String permission : permissions) {
            if (!hasPermissionFor(permission)) permissionsList.add(permission);
        }

        String[] permissionsArray = permissionsList.toArray(new String[permissionsList.size()]);

        ActivityCompat.requestPermissions(activity, permissionsArray, requestCode);
    }
}
