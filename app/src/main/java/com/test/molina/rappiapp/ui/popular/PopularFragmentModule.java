package com.test.molina.rappiapp.ui.popular;

import android.support.v7.widget.LinearLayoutManager;

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
