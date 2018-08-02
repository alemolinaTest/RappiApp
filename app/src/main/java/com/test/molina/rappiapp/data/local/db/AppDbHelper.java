package com.test.molina.rappiapp.data.local.db;

import com.test.molina.rappiapp.data.model.db.Genre;
import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }


    @Override
    public Observable<List<PopularMovie>> getAllLocalPopular() {
        /*Observable.fromCallable: Returns an Observable that, when an observer subscribes to it,
        invokes a function you specify and then emits the value returned from that function.*/

        return Observable.fromCallable(new Callable<List<PopularMovie>>() {
            //Callable: A task that returns a result and may throw an exception.
            // Implementors define a single method with no arguments called call.
            @Override
            public List<PopularMovie> call() throws Exception {//getting collection of questions
                return mAppDatabase.movieDao().loadAllPopular();
            }
        });
    }

    @Override
    public Observable<List<TopRatedMovie>> getAllLocalTopRated() {
         /*Observable.fromCallable: Returns an Observable that, when an observer subscribes to it,
        invokes a function you specify and then emits the value returned from that function.*/

        return Observable.fromCallable(new Callable<List<TopRatedMovie>>() {
            //Callable: A task that returns a result and may throw an exception.
            // Implementors define a single method with no arguments called call.
            @Override
            public List<TopRatedMovie> call() throws Exception {//getting collection of questions
                return mAppDatabase.movieDao().loadAllTopRated();
            }
        });
    }

    @Override
    public Observable<List<UpcomingMovie>> getAllLocalUpcoming() {
           /*Observable.fromCallable: Returns an Observable that, when an observer subscribes to it,
        invokes a function you specify and then emits the value returned from that function.*/

        return Observable.fromCallable(new Callable<List<UpcomingMovie>>() {
            //Callable: A task that returns a result and may throw an exception.
            // Implementors define a single method with no arguments called call.
            @Override
            public List<UpcomingMovie> call() throws Exception {//getting collection of questions
                return mAppDatabase.movieDao().loadAllUpcoming();
            }
        });
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {
        /*Observable.fromCallable: Returns an Observable that, when an observer subscribes to it,
        invokes a function you specify and then emits the value returned from that function.*/

        return Observable.fromCallable(new Callable<List<Genre>>() {
            //Callable: A task that returns a result and may throw an exception.
            // Implementors define a single method with no arguments called call.
            @Override
            public List<Genre> call() throws Exception {//getting collection of questions
                return mAppDatabase.genreDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> isGenreEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.genreDao().loadAll().isEmpty();
            }
        });
    }

    @Override
    public Observable<Boolean> saveGenre(final Genre question) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.genreDao().insert(question);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveGenreList(final List<Genre> questionList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.genreDao().insertAll(questionList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> savePopularMoviesList(final List<PopularMovie> moviesList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.movieDao().insertAllPopular(moviesList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveTopRatedMoviesList(final List<TopRatedMovie> moviesList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.movieDao().insertAllTopRated(moviesList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveUpcomingMoviesList(final List<UpcomingMovie> moviesList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.movieDao().insertAllUpcoming(moviesList);
                return true;
            }
        });
    }

}
