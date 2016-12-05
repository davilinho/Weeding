package com.davidroid.wedding.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidroid.wedding.util.MailManager;
import com.davidroid.wedding.util.MailType;
import com.davidroid.wedding.util.PhoneManager;
import com.davidroid.wedding.util.WhatsappManager;
import com.davidroid.weeding.BuildConfig;
import com.davidroid.weeding.R;

/**
 * Created by davidmartin on 5/12/16.
 */

public class ContactFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container, false);
        Toolbar toolbar = ((Toolbar) view.findViewById(R.id.toolbar));
        ((TextView) toolbar.findViewById(R.id.text_toolbar)).setText("David y Sandra");

        ImageView phoneSandra = (ImageView) view.findViewById(R.id.phone_sandra);
        phoneSandra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PhoneManager(getActivity()).phoneTo(BuildConfig.PHONE_SANDRA);
            }
        });

        ImageView mailSandra = (ImageView) view.findViewById(R.id.mail_sandra);
        mailSandra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MailManager(getActivity(), MailType.CONTACT).mailTo(BuildConfig.MAIL_SANDRA,
                        "Hola Sandra, te escribía en relación a la boda...");
            }
        });

        ImageView whatsappSandra = (ImageView) view.findViewById(R.id.whatsapp_sandra);
        whatsappSandra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new WhatsappManager(getActivity()).whatsappTo();
            }
        });

        ImageView phoneDavid = (ImageView) view.findViewById(R.id.phone_david);
        phoneDavid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PhoneManager(getActivity()).phoneTo(BuildConfig.PHONE_DAVID);
            }
        });

        ImageView mailDavid = (ImageView) view.findViewById(R.id.mail_david);
        mailDavid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MailManager(getActivity(), MailType.CONTACT).mailTo(BuildConfig.MAIL_DAVID,
                        "Hola David, te escribía en relación a la boda...");
            }
        });

        ImageView whatsappDavid = (ImageView) view.findViewById(R.id.whatsapp_david);
        whatsappDavid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new WhatsappManager(getActivity()).whatsappTo();
            }
        });

        return view;
    }
}
