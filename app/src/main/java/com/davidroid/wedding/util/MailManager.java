package com.davidroid.wedding.util;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by davidmartin on 5/12/16.
 */

public class MailManager {

    private Activity activity;
    private MailType mailType;

    public MailManager(Activity activity, MailType mailType) {
        this.activity = activity;
        this.mailType = mailType;
    }

    public void sendMail(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"davilinho@gmail.com"});
        if (MailType.MUSIC == mailType) {
            intent.putExtra(Intent.EXTRA_SUBJECT, "Música");
        } else {
            intent.putExtra(Intent.EXTRA_SUBJECT, "Confirmación");
        }
        intent.putExtra(Intent.EXTRA_TEXT, message);
        try {
            activity.startActivity(Intent.createChooser(intent, "Elige la aplicación de correo con la que desees enviar el correo"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(activity, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
