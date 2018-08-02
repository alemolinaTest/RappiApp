package com.test.molina.rappiapp.ui.main;

import android.app.SearchManager;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.test.molina.rappiapp.BR;
import com.test.molina.rappiapp.R;
import com.test.molina.rappiapp.databinding.ActivityMainBinding;
import com.test.molina.rappiapp.ui.base.BaseActivity;
import com.test.molina.rappiapp.ui.popular.PopularViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Amolina on 02/02/17.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements HasSupportFragmentInjector {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    /*
        @Inject
        PopularViewModel mPopularViewModel;
    */
    @Inject
    MainViewModel mMainViewModel;

    @Inject
    MainPagerAdapter mPagerAdapter;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    ActivityMainBinding mActivityMainBinding;
    private SearchView searchView;

    private PopularViewModel mPopularViewModel;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        setUp();

    }

    private void setUp() {


        setSupportActionBar(mActivityMainBinding.toolbar);

        mPagerAdapter.setCount(3);

        mActivityMainBinding.mainViewPager.setAdapter(mPagerAdapter);

        mActivityMainBinding.tabLayout.addTab(mActivityMainBinding.tabLayout.newTab().setText(getString(R.string.popular)));
        mActivityMainBinding.tabLayout.addTab(mActivityMainBinding.tabLayout.newTab().setText(getString(R.string.top_rated)));
        mActivityMainBinding.tabLayout.addTab(mActivityMainBinding.tabLayout.newTab().setText(getString(R.string.upcoming)));

        mActivityMainBinding.mainViewPager.setOffscreenPageLimit(mActivityMainBinding.tabLayout.getTabCount());

        mActivityMainBinding.mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mActivityMainBinding.tabLayout));

        mActivityMainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mActivityMainBinding.mainViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public PopularViewModel getPopularViewModel() {
        mPopularViewModel = ViewModelProviders.of(this, mViewModelFactory).get(PopularViewModel.class);
        return mPopularViewModel;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                mPopularViewModel.fetchAll("");
                return false;
            }
        });


        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                getPopularViewModel();
                mPopularViewModel.fetchAll(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}
