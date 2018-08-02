package com.test.molina.rappiapp.data;

import android.content.Context;

import com.test.molina.rappiapp.data.local.db.DbHelper;
import com.test.molina.rappiapp.data.model.api.GenreResponse;
import com.test.molina.rappiapp.data.model.api.PopularMovieResponse;
import com.test.molina.rappiapp.data.model.api.TopRatedMovieResponse;
import com.test.molina.rappiapp.data.model.api.UpcomingMovieResponse;
import com.test.molina.rappiapp.data.model.db.Genre;
import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;
import com.test.molina.rappiapp.data.remote.ApiHeader;
import com.test.molina.rappiapp.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    final Context mContext;
    final DbHelper mDbHelper;
    final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(Context context,
                          DbHelper dbHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }


    @Override
    public void updateApiHeader(String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<Boolean> isGenreEmpty() {
        return mDbHelper.isGenreEmpty();
    }

    @Override
    public Observable<Boolean> saveGenre(Genre genre) {
        return mDbHelper.saveGenre(genre);
    }

    @Override
    public Observable<Boolean> saveGenreList(List<Genre> genreList) {
        return mDbHelper.saveGenreList(genreList);
    }

    @Override
    public Observable<Boolean> savePopularMoviesList(List<PopularMovie> moviesList) {
        return mDbHelper.savePopularMoviesList(moviesList);
    }

    @Override
    public Observable<Boolean> saveTopRatedMoviesList(List<TopRatedMovie> moviesList) {
        return mDbHelper.saveTopRatedMoviesList(moviesList);
    }

    @Override
    public Observable<Boolean> saveUpcomingMoviesList(List<UpcomingMovie> moviesList) {
        return mDbHelper.saveUpcomingMoviesList(moviesList);
    }

    @Override
    public Observable<List<PopularMovie>> getAllLocalPopular() {
        return mDbHelper.getAllLocalPopular();
    }

    @Override
    public Observable<List<TopRatedMovie>> getAllLocalTopRated() {
        return mDbHelper.getAllLocalTopRated();
    }

    @Override
    public Observable<List<UpcomingMovie>> getAllLocalUpcoming() {
        return mDbHelper.getAllLocalUpcoming();
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {
        return mDbHelper.getAllGenres();
    }

    @Override
    public Observable<GenreResponse> getGenresApiCall() {
        return mApiHelper.getGenresApiCall();
    }

    @Override
    public Observable<PopularMovieResponse> getPopularMoviesApiCall() {
        return mApiHelper.getPopularMoviesApiCall();
    }

    @Override
    public Observable<TopRatedMovieResponse> getTopRatedMoviesApiCall() {
        return mApiHelper.getTopRatedMoviesApiCall();
    }

    @Override
    public Observable<UpcomingMovieResponse> getUpcomingMoviesApiCall() {
        return mApiHelper.getUpcomingMoviesApiCall();
    }
/*
    @Override
    public Observable<List<QuestionCardData>> getQuestionCardData() {
        //AppDBHelper getAllQuestions, returns Observable<List<Question>>
        return mDbHelper.getAllQuestions()
        /** FlatMap
         * Returns an Observable that emits items based on applying a function that you supply to each item emitted
         * by the source ObservableSource, where that function returns an ObservableSource, and then merging those resulting
         * ObservableSources and emitting the results of this merger.

                //Function: A functional interface that takes a value and returns another value, possibly with a
                //different type and allows throwing a checked exception.
                .flatMap(new Function<List<Question>, ObservableSource<Question>>() {
                    @Override
                    public ObservableSource<Question> apply(List<Question> questions) throws Exception {
                        //Converts an sequence into an ObservableSource that emits the items in the sequence
                        return Observable.fromIterable(questions);
                    }
                })//get all the questions
                //now for every question it gets the options by using the question.id
                .flatMap(new Function<Question, ObservableSource<QuestionCardData>>() {
                    @Override
                    public ObservableSource<QuestionCardData> apply(Question question) throws Exception {
                        //zip Returns an Observable that emits the results of a specified
                        // combiner function applied to combinations of
                        // two items emitted, in sequence, by two other ObservableSources.
                        return Observable.zip(mDbHelper.getOptionsForQuestionId(question.id), Observable.just(question),
                                //BiFunction: A functional interface (callback) that computes a value based on multiple input values.
                                new BiFunction<List<Option>, Question, QuestionCardData>() {
                                    @Override
                                    public QuestionCardData apply(List<Option> options, Question question) throws Exception {
                                        return new QuestionCardData(question, options);
                                    }
                                });
                    }
                })
                .toList()
                .toObservable();
    }
    */
}
