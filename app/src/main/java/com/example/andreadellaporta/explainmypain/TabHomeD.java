package com.example.andreadellaporta.explainmypain;

/**
 * Created by andreadellaporta on 20/01/17.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class TabHomeD extends Fragment {
    ViewPager vp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_home_d, container, false);

        ImageButton entry=(ImageButton) rootView.findViewById(R.id.entryD);
        vp=(ViewPager) getActivity().findViewById(R.id.container2);

        entry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                vp.setCurrentItem(1);
            }
        });

        ImageButton report=(ImageButton) rootView.findViewById(R.id.newreportD);
        report.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                vp.setCurrentItem(2);
            }
        });

        return rootView;
    }

}
