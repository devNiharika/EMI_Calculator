package com.emi_calculator.Utils;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;
import com.facebook.stetho.Stetho;

/**
 * Created by Niharika Rastogi on 23-04-2017.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        Stetho.initializeWithDefaults(this);
    }
}
