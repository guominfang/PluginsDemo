package com.kwok.pluginslib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author gmf
 * @description
 * @date 2019/5/7.
 */
public class PluginActivity extends Activity implements IPlugin {

    private int mFrom = FROM_INTERNAL;

    private Activity mProxyActivity;

    @Override
    public void attach(Activity proxyActivity) {
        mProxyActivity = proxyActivity;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        if (saveInstanceState != null) {
            mFrom = saveInstanceState.getInt("FROM");
        }
        if (mFrom == FROM_INTERNAL) {
            super.onCreate(saveInstanceState);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (mFrom == FROM_INTERNAL) {
            super.setContentView(layoutResID);
        } else {
            mProxyActivity.setContentView(layoutResID);
        }
    }

    @Override
    public void onStart() {
        if (mFrom == FROM_INTERNAL) {
            super.onStart();
        }
    }

    @Override
    public void onRestart() {
        if (mFrom == FROM_INTERNAL) {
            super.onRestart();
        }
    }

    @Override
    public void onResume() {
        if (mFrom == FROM_INTERNAL) {
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if (mFrom == FROM_INTERNAL) {
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mFrom == FROM_INTERNAL) {
            super.onStop();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (mFrom == FROM_INTERNAL) {
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }

    @Override
    public void onDestroy() {
        if (mFrom == FROM_INTERNAL) {
            super.onDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (mFrom == FROM_INTERNAL) {
            super.onNewIntent(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        if (mFrom == FROM_INTERNAL) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (mFrom == FROM_INTERNAL) {
            super.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mFrom == FROM_INTERNAL) {
            super.onSaveInstanceState(outState);
        }
    }
}
