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
import android.widget.RadioButton;
import android.widget.TextView;

import com.davidroid.wedding.util.MailType;
import com.davidroid.weeding.BuildConfig;
import com.davidroid.weeding.R;
import com.davidroid.wedding.util.MailManager;

/**
 * Created by david on 27/11/16.
 */

@SuppressWarnings("ALL")
public class ConfirmationFragment extends Fragment {

    private EditText name;
    private RadioButton adult;
    private RadioButton kid;
    private EditText comments;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.confirmation_fragment, container, false);
        android.support.v7.widget.Toolbar toolbar = ((android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar));
        ((TextView) toolbar.findViewById(R.id.text_toolbar)).setText("Confirmación invitados");

        name = (EditText) view.findViewById(R.id.name);
        adult = (RadioButton) view.findViewById(R.id.menu_adult);
        kid = (RadioButton) view.findViewById(R.id.menu_kid);
        comments = (EditText) view.findViewById(R.id.comments);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().trim().isEmpty()) {
                    name.setError("El nombre es obligatorio");
                } else {
                    String menuType = null;
                    if (adult.isChecked()) {
                        menuType = "adulto";
                    }
                    if (kid.isChecked()) {
                        menuType = "intanfil";
                    }
                    final String text = "- Nombre: " + name.getText() + "\n\n- Menu: " + menuType + "\n\n- Comentarios: "
                            + comments.getText() + "\n\n";
                    new AlertDialog.Builder(getContext())
                            .setTitle("Confirmación")
                            .setMessage("¿Deseas enviar esta confirmación?\n\n\n" + text)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    new MailManager(getActivity(), MailType.CONFIRMATION).mailTo(BuildConfig.MAIL_DAVID,
                                            text);
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
