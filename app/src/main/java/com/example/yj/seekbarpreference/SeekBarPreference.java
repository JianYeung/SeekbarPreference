package com.example.yj.seekbarpreference;

import android.content.Context;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


/**
 * Created by 70889 on 2016/10/18.
 */

public class SeekBarPreference extends Preference implements SeekBar.OnSeekBarChangeListener {

    private static SeekBar seekBar;
    private static int mprogress;
    private static boolean flag = false;


    public SeekBarPreference(Context context) {
        super(context);
    }


    public SeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        seekBar = (SeekBar) view.findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        mprogress = getPersistedInt(200);
        // System.out.println("Yj----1" + seekBar.getMax());
        seekBar.setProgress(mprogress);

    }


    public  int getMprogress() {
        return mprogress;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //System.out.println("Yj-----" + progress);
        mprogress = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //System.out.println("Yj----2" + seekBar.getProgress());
        if (shouldPersist()) {
           // System.out.println("Yj----3" + seekBar.getProgress());
            persistInt(seekBar.getProgress());
        }

    }
}

