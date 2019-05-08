package com.kwok.pluginslib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * @author gmf
 * @description 插件apk的实体对象
 * @date 2019/5/7.
 */
public class PluginApk {

    private PackageInfo mPackageInfo;
    private Resources mResources;
    private AssetManager mAssetManager;
    private DexClassLoader mClassLoader;

    public PluginApk(PackageInfo packageInfo, Resources resources, DexClassLoader classLoader) {
        mPackageInfo = packageInfo;
        mResources = resources;
        mClassLoader = classLoader;
        mAssetManager = mResources.getAssets();
    }

    public PackageInfo getPackageInfo() {
        return mPackageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        mPackageInfo = packageInfo;
    }

    public Resources getResources() {
        return mResources;
    }

    public void setResources(Resources resources) {
        mResources = resources;
    }

    public AssetManager getAssetManager() {
        return mAssetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        mAssetManager = assetManager;
    }

    public DexClassLoader getClassLoader() {
        return mClassLoader;
    }

    public void setClassLoader(DexClassLoader classLoader) {
        mClassLoader = classLoader;
    }
}
