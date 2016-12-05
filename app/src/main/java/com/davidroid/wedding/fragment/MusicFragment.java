package com.davidroid.wedding.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.davidroid.weeding.R;
import com.davidroid.wedding.util.MailManager;
import com.davidroid.wedding.util.MailType;

/**
 * Created by david on 27/11/16.
 */

@SuppressWarnings("ALL")
public class MusicFragment extends Fragment {

    private EditText song;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_fragment, container, false);
        android.support.v7.widget.Toolbar toolbar = ((android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar));
        ((TextView) toolbar.findViewById(R.id.text_toolbar)).setText("Sugeréncias musicales");

        song = (EditText) view.findViewById(R.id.song);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (song.getText().toString().trim().isEmpty()) {
                    song.setError("Indica qué canción desearías escuchar/bailar");
                } else {
                    new AlertDialog.Builder(getContext())
                            .setTitle("Sugeréncia musical")
                            .setMessage("¿Deseas escuchar/bailar esta canción?\n\n\n" + song.getText())
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    new MailManager(getActivity(), MailType.MUSIC).sendMail(song.getText().toString());
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setIcon(android.R.drawable.checkbox_on_background)
                            .show();
                }
            }
        });

        return view;
    }
}
