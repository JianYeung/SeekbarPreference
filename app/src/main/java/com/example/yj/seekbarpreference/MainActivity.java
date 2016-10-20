package com.example.yj.seekbarpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity implements SeekBarPreference.OnSeekBarPrefsChangeListener {

    static SeekBarPreference seekBarPreference;
    static int progress;
    static MainActivity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a=this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getFragmentManager().beginTransaction().add(R.id.content_main, new SeekBarFragment()).commit();

    }



    @Override
    public void onStopTrackingTouch(String key, SeekBar seekBar) {

    }

    @Override
    public void onStartTrackingTouch(String key, SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(String key, SeekBar seekBar, int progress, boolean fromUser) {
        System.out.println("YJJ"+progress);
    }


    public static class SeekBarFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);
            seekBarPreference = (SeekBarPreference) findPreference("seekbar");
            seekBarPreference.setDefaultProgressValue(100);
            seekBarPreference.setMax(255);
            seekBarPreference.setOnSeekBarPrefsChangeListener(a);
        }

    }
}
