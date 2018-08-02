package com.test.molina.rappiapp.di.builder;

import com.test.molina.rappiapp.ui.main.MainActivity;
import com.test.molina.rappiapp.ui.main.MainActivityModule;
import com.test.molina.rappiapp.ui.popular.PopularFragmentProvider;
import com.test.molina.rappiapp.ui.splash.SplashActivity;
import com.test.molina.rappiapp.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Amolina on 14/09/17.
 */

// We map all our activities here, with their modules, that provides the correspondent ViewModel
@Module
public abstract class ActivityBuilder {
/* UI subcomponents(SplashActivityComponent , LoginActivityComponent, MainActivityComponent)
    are just like bridges to get the modules in the graph, those modules provide the ViewModel class
    With this annotation, we can easily attach activities/fragments to dagger graph
    without using components for every activity*/

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class,PopularFragmentProvider.class})
    abstract MainActivity bindFeedActivity();

}
