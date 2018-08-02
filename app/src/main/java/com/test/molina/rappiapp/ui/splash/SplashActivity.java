package com.test.molina.rappiapp.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.test.molina.rappiapp.BR;
import com.test.molina.rappiapp.R;
import com.test.molina.rappiapp.databinding.ActivitySplashBinding;
import com.test.molina.rappiapp.ui.base.BaseActivity;
import com.test.molina.rappiapp.ui.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by Amolina on 02/02/17.
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.fetchGenres();
        mSplashViewModel.fetchPopularMovies();
        mSplashViewModel.fetchTopRatedMovies();
        mSplashViewModel.fetchUpcomingMovies();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

}
