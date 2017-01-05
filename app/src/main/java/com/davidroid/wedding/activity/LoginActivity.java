package com.davidroid.wedding.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.davidroid.weeding.BuildConfig;
import com.davidroid.weeding.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("isLogged", "").equals("true")) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else {

            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText input = (EditText) findViewById(R.id.passwd);
                    if (BuildConfig.TOKEN.toString().equals(input.getText().toString())) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("isLogged", "true");
                        editor.commit();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Snackbar.make(findViewById(android.R.id.content), "Ponte en contacto con nosotros si no puedes acceder.",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}
