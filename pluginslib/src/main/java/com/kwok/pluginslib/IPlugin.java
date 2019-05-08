package com.kwok.pluginslib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author gmf
 * @description
 * @date 2019/5/7.
 */
public interface IPlugin {

    int FROM_INTERNAL = 0;
    int FROM_EXTERNAL = 1;

    void attach(Activity proxyActivity);

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onActivityResult(int requestCode, int resultCode, Intent intent);

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);
}
