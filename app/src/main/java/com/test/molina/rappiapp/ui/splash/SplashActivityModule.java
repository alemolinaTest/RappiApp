package com.test.molina.rappiapp.ui.splash;

import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new SplashViewModel(dataManager, schedulerProvider);
    }

}
