package com.test.molina.rappiapp;

import android.app.Activity;
import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.facebook.stetho.Stetho;
import com.test.molina.rappiapp.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Amolina on 02/02/17.
 */

public class RappiApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger 2 creates the DaggerComponent classes during compilation
        //see AppComponent
        Stetho.initializeWithDefaults(this);

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        //set style to text views like style="@style/TextStyle.Heading"
        //using fontPath with custom fonts (ttf)
        CalligraphyConfig.initDefault(mCalligraphyConfig);


        //instead of retrofit, implement http2, reduce latency, 50% faster
        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

}
