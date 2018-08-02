
package com.test.molina.rappiapp.di.module;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.test.molina.rappiapp.BuildConfig;
import com.test.molina.rappiapp.R;
import com.test.molina.rappiapp.ViewModelProviderFactory;
import com.test.molina.rappiapp.data.AppDataManager;
import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.data.local.db.AppDatabase;
import com.test.molina.rappiapp.data.local.db.AppDbHelper;
import com.test.molina.rappiapp.data.local.db.DbHelper;
import com.test.molina.rappiapp.data.remote.ApiHeader;
import com.test.molina.rappiapp.data.remote.ApiHelper;
import com.test.molina.rappiapp.data.remote.ApiInterceptor;
import com.test.molina.rappiapp.data.remote.AppApiHelper;
import com.test.molina.rappiapp.di.ApiInfo;
import com.test.molina.rappiapp.di.DatabaseInfo;
import com.test.molina.rappiapp.rx.AppSchedulerProvider;
import com.test.molina.rappiapp.rx.SchedulerProvider;
import com.test.molina.rappiapp.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey, "");
    }

    @Provides
    @Singleton
    ApiInterceptor provideApiHeaders() {
        return new ApiInterceptor();
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@NonNull ApiInterceptor apiHeaders) {
        return new OkHttpClient.Builder().addInterceptor(apiHeaders)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor()).build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }



}

