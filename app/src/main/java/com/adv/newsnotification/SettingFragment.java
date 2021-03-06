package com.adv.newsnotification;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.pushbots.push.Pushbots;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private final String NAME_FILE_SETTING = "setting_notification";

    private Switch switchNews; // Tag = 1
    private Switch switchPolitical; // Tag = 2
    private Switch switchTechnology; // Tag = 3
    private Switch switchEntertainment; // Tag = 4
    private Switch switchEducation; // Tag = 5
    private Switch switchCriminal; // Tag = 6
    private Switch switchSport; // Tag = 7
    private Switch switchSocial; // Tag = 8

    private SharedPreferences settings;
    SharedPreferences.Editor editor;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Pushbots.sharedInstance().init(view.getContext());

        settings = getActivity().getSharedPreferences(NAME_FILE_SETTING, 0);

        switchNews = (Switch) view.findViewById(R.id.switch_news);
        switchPolitical = (Switch) view.findViewById(R.id.switch_political);
        switchTechnology = (Switch) view.findViewById(R.id.switch_technology);
        switchEntertainment = (Switch) view.findViewById(R.id.switch_entertainment);
        switchEducation = (Switch) view.findViewById(R.id.switch_education);
        switchCriminal = (Switch) view.findViewById(R.id.switch_criminal);
        switchSport = (Switch) view.findViewById(R.id.switch_sport);
        switchSocial = (Switch) view.findViewById(R.id.switch_social);

        //Load Setting
        switchNews.setChecked(settings.getBoolean("switchNews", false));
        switchPolitical.setChecked(settings.getBoolean("switchPolitical", false));
        switchTechnology.setChecked(settings.getBoolean("switchTechnology", false));
        switchEntertainment.setChecked(settings.getBoolean("switchEntertainment", false));
        switchEducation.setChecked(settings.getBoolean("switchEducation", false));
        switchCriminal.setChecked(settings.getBoolean("switchCriminal", false));
        switchSport.setChecked(settings.getBoolean("switchSport", false));
        switchSocial.setChecked(settings.getBoolean("switchSocial", false));

        switchNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchNews.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.NEWS_NEWS));
                    editor.putBoolean("switchNews", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.NEWS_NEWS));
                    editor.putBoolean("switchNews", false);
                }
                editor.commit();
            }
        });
        switchPolitical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchPolitical.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.POLITICAL_NEWS));
                    editor.putBoolean("switchPolitical", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.POLITICAL_NEWS));
                    editor.putBoolean("switchPolitical", false);
                }
                editor.commit();
            }
        });
        switchTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchTechnology.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.TECHNOLOGY_NEWS));
                    editor.putBoolean("switchTechnology", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.TECHNOLOGY_NEWS));
                    editor.putBoolean("switchTechnology", false);
                }
                editor.commit();
            }
        });
        switchEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchEntertainment.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.ENTERTAINMENT_NEWS));
                    editor.putBoolean("switchEntertainment", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.ENTERTAINMENT_NEWS));
                    editor.putBoolean("switchEntertainment", false);
                }
                editor.commit();
            }
        });
        switchEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchEducation.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.EDUCATION_NEWS));
                    editor.putBoolean("switchEducation", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.EDUCATION_NEWS));
                    editor.putBoolean("switchEducation", false);
                }
                editor.commit();
            }
        });
        switchCriminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchCriminal.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.CRIMINAL_NEWS));
                    editor.putBoolean("switchCriminal", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.CRIMINAL_NEWS));
                    editor.putBoolean("switchCriminal", false);
                }
                editor.commit();
            }
        });
        switchSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchSport.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.SPORT_NEWS));
                    editor.putBoolean("switchSport", true);
                } else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.SPORT_NEWS));
                    editor.putBoolean("switchSport", false);
                }
                editor.commit();
            }
        });
        switchSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = settings.edit();
                if (switchSocial.isChecked()) {
                    Pushbots.sharedInstance().tag(String.valueOf(SelectNews.SOCIAL_NEWS));
                    editor.putBoolean("switchSocial", true);
                }
                else {
                    Pushbots.sharedInstance().untag(String.valueOf(SelectNews.SOCIAL_NEWS));
                    editor.putBoolean("switchSocial", false);
                }
                editor.commit();
            }
        });
    }
}
