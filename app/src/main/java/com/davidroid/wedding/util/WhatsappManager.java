package com.davidroid.wedding.util;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by davidmartin on 5/12/16.
 */

public class WhatsappManager {

    private Activity activity;

    public WhatsappManager(Activity activity) {
        this.activity = activity;
    }

    public void whatsappTo() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola, te escribo en relación a la aplicación de la Boda...");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        activity.startActivity(sendIntent);
    }
}
