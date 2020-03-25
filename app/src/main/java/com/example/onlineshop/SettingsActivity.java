package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

public static final String KEY_PREF_SWITCH = "example_switch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new SettingsFragment())
                .commit();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean switchPref = sharedPreferences.getBoolean(SettingsActivity.KEY_PREF_SWITCH,false);
    }

}
