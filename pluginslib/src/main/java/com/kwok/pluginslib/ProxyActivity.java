package com.kwok.pluginslib;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

/**
 * @author gmf
 * @description 代理Activity ，管理Activity的生命周期
 * @date 2019/5/7.
 */
public class ProxyActivity extends Activity {

    private String mClassName;
    private PluginApk mPluginApk;
    private IPlugin mIPlugin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClassName = getIntent().getStringExtra("className");
        mPluginApk = PluginManager.getInstance().getPluginApk();
        launchPluginActivity();
    }

    private void launchPluginActivity() {
        if (mPluginApk == null) {
            throw new RuntimeException("load your apk file first please!");
        }
        try {
            Class<?> clazz = mPluginApk.getClassLoader().loadClass(mClassName);
            Object object = clazz.newInstance();

            if (object instanceof IPlugin) {
                mIPlugin = (IPlugin) object;
                mIPlugin.attach(this);
                Bundle bundle = new Bundle();
                bundle.putInt("FROM", IPlugin.FROM_EXTERNAL);
                mIPlugin.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return mPluginApk != null ? mPluginApk.getResources() : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null ? mPluginApk.getAssetManager() : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk != null ? mPluginApk.getClassLoader() : super.getClassLoader();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mIPlugin != null) {
            mIPlugin.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mIPlugin != null) {
            mIPlugin.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mIPlugin != null) {
            mIPlugin.onResume();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mIPlugin != null) {
            mIPlugin.onNewIntent(intent);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mIPlugin != null) {
            mIPlugin.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mIPlugin != null) {
            mIPlugin.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mIPlugin != null) {
            mIPlugin.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mIPlugin != null) {
            mIPlugin.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mIPlugin != null) {
            mIPlugin.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mIPlugin != null) {
            mIPlugin.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIPlugin != null) {
            mIPlugin.onDestroy();
        }
    }
}
