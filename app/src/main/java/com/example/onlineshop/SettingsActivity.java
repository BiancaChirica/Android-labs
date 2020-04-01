package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Switch;

public class SettingsActivity extends PreferenceActivity {
    public static final String KEY_PREF_SWITCH = "example_switch";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName("my_prefs");
        addPreferencesFromResource(R.xml.preference);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean switchPref = sharedPreferences.getBoolean(com.example.onlineshop.SettingsActivity.KEY_PREF_SWITCH, false);
    }

}