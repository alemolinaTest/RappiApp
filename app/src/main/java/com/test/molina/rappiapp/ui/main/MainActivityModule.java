package com.test.molina.rappiapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;

import com.test.molina.rappiapp.ViewModelProviderFactory;
import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.rx.SchedulerProvider;
import com.test.molina.rappiapp.ui.popular.PopularViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }

    @Provides
    MainPagerAdapter provideMainPagerAdapter(MainActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }



    @Provides
    ViewModelProvider.Factory providePopularViewModel(PopularViewModel popularViewModel) {
        return new ViewModelProviderFactory<>(popularViewModel);
    }

    @Provides
    PopularViewModel PopularViewModel(DataManager dataManager,
                                      SchedulerProvider schedulerProvider) {
        return new PopularViewModel(dataManager, schedulerProvider);
    }

}
