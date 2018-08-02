package com.test.molina.rappiapp.ui.splash;

import android.arch.lifecycle.MutableLiveData;

import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.data.model.api.GenreResponse;
import com.test.molina.rappiapp.data.model.api.PopularMovieResponse;
import com.test.molina.rappiapp.data.model.api.TopRatedMovieResponse;
import com.test.molina.rappiapp.data.model.api.UpcomingMovieResponse;
import com.test.molina.rappiapp.data.model.db.Genre;
import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;
import com.test.molina.rappiapp.rx.SchedulerProvider;
import com.test.molina.rappiapp.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * Created by Amolina on 02/02/17.
 */
//all viewmodels has DataManager and SchedulerProvider
public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    private final MutableLiveData<List<Genre>> openSourceItemsLiveData;

    public SplashViewModel(DataManager dataManager,
                           SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        openSourceItemsLiveData = new MutableLiveData<>();
    }

    public void fetchGenres() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getGenresApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GenreResponse>() {
                    @Override
                    public void accept(@NonNull GenreResponse genreResponse){
                        if (genreResponse != null && genreResponse.getData() != null) {
                            saveGenresList(genreResponse.getData());
                        }
                        //setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                       // setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }


    public void saveGenresList(List<Genre> list) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .saveGenreList(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {

                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }


    public void fetchPopularMovies() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getPopularMoviesApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PopularMovieResponse>() {
                    @Override
                    public void accept(@NonNull PopularMovieResponse genreResponse){
                        if (genreResponse != null && genreResponse.getData() != null) {
                            savePopularMoviesList(genreResponse.getData());
                        }
                        //setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        // setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));


    }


    public void savePopularMoviesList(List<PopularMovie> list) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .savePopularMoviesList(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {

                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        gotoNextActivity();
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public void fetchTopRatedMovies() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getTopRatedMoviesApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<TopRatedMovieResponse>() {
                    @Override
                    public void accept(@NonNull TopRatedMovieResponse genreResponse){
                        if (genreResponse != null && genreResponse.getData() != null) {
                            saveTopRatedMoviesList(genreResponse.getData());
                        }
                        //setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        // setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));


    }


    public void saveTopRatedMoviesList(List<TopRatedMovie> list) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .saveTopRatedMoviesList(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {

                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public void fetchUpcomingMovies() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getUpcomingMoviesApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UpcomingMovieResponse>() {
                    @Override
                    public void accept(@NonNull UpcomingMovieResponse genreResponse){
                        if (genreResponse != null && genreResponse.getData() != null) {
                            saveUpcomingMoviesList(genreResponse.getData());
                        }
                        //setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        // setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));


    }


    public void saveUpcomingMoviesList(List<UpcomingMovie> list) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .saveUpcomingMoviesList(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {

                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                        setIsLoading(false);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    private void gotoNextActivity() {
        getNavigator().openMainActivity();
    }

}
