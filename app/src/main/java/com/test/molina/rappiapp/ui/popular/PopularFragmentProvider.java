package com.test.molina.rappiapp.ui.popular;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public abstract class PopularFragmentProvider {

    @ContributesAndroidInjector(modules = PopularFragmentModule.class)
    abstract PopularFragment providePopularFragmentFactory();

}
