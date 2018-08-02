package com.test.molina.rappiapp.di.component;

import android.app.Application;

import com.test.molina.rappiapp.RappiApp;
import com.test.molina.rappiapp.di.builder.ActivityBuilder;
import com.test.molina.rappiapp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Amolina on 02/02/17.
 */

// Component is a graph. We build a component. Component will provide injected instances by using modules
//AppModule get application Context, provideAppDatabase builds the database, provideDbHelper,providePreferencesHelper, provideApiHelper
//AndroidInjectionModule -Provides our activities and fragments with given module
//ActivityBuilder - We map all our activities here
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(RappiApp app);

}
