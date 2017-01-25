package com.example.andreadellaporta.explainmypain;

/**
 * Created by andreadellaporta on 20/01/17.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabSettings extends Fragment{

    private TextView name;
    private TextView surname;
    private TextView birth;
    private TextView gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_settings_p, container, false);

        name=(TextView) rootView.findViewById(R.id.settingsName);
        surname=(TextView) rootView.findViewById(R.id.settingsSurname);
        birth=(TextView) rootView.findViewById(R.id.settingsBirth);
        gender=(TextView) rootView.findViewById(R.id.setingsGender);

        name.setText(SharedPrefManager.getInstance(this.getContext()).getName());
        surname.setText(SharedPrefManager.getInstance(this.getContext()).getSurname());
        birth.setText(SharedPrefManager.getInstance(this.getContext()).getBirth());
        gender.setText(SharedPrefManager.getInstance(this.getContext()).getGender());


        return rootView;
    }
}
