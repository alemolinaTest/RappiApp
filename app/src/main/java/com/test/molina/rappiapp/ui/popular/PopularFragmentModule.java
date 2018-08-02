package com.test.molina.rappiapp.ui.popular;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.test.molina.rappiapp.ViewModelProviderFactory;
import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class PopularFragmentModule {

    @Provides
    PopularAdapter providePopularAdapter() {
        return new PopularAdapter();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(PopularFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }



}
