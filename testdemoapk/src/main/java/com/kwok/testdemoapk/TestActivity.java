package com.kwok.testdemoapk;

import android.os.Bundle;

import com.kwok.pluginslib.PluginActivity;

public class TestActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
