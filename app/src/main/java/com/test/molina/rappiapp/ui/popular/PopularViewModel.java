package com.test.molina.rappiapp.ui.popular;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;
import com.test.molina.rappiapp.data.remote.ApiEndPoint;
import com.test.molina.rappiapp.rx.SchedulerProvider;
import com.test.molina.rappiapp.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Amolina on 02/02/17.
 */

public class PopularViewModel extends BaseViewModel<PopularNavigator> {

    private final ObservableArrayList<PopularItemViewModel> popularItemViewModels = new ObservableArrayList<>();
    private final ObservableArrayList<PopularItemViewModel> topRatedItemViewModels = new ObservableArrayList<>();
    private final ObservableArrayList<PopularItemViewModel> upcomingItemViewModels = new ObservableArrayList<>();

    private final MutableLiveData<List<PopularItemViewModel>> popularItemsLiveData;
    private final MutableLiveData<List<PopularItemViewModel>> topRatedItemsLiveData;
    private final MutableLiveData<List<PopularItemViewModel>> upcomingItemsLiveData;


    public PopularViewModel(DataManager dataManager,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        popularItemsLiveData = new MutableLiveData<>();
        topRatedItemsLiveData = new MutableLiveData<>();
        upcomingItemsLiveData = new MutableLiveData<>();
        fetchAll("");
    }


    public void fetchAll(String filter) {
        fetchPopularRepo(filter);
        fetchTopRatedRepo(filter);
        fetchUpcomingRepo(filter);
    }


    public void fetchPopularRepo(String searching) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getAllLocalPopular()
                .flatMap((Function<List<PopularMovie>, ObservableSource<PopularMovie>>) questions -> {
                    //Converts an sequence into an ObservableSource that emits the items in the sequence
                    return Observable.fromIterable(questions);
                })
                .filter(movie -> movie.overview.contains(searching))
                .toList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(popularMovies -> {
                    if (popularMovies != null && popularMovies != null) {
                        popularItemsLiveData.setValue(getViewModelList(popularMovies));
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }


    public List<PopularItemViewModel> getViewModelList(List<PopularMovie> repoList) {
        ArrayList<PopularItemViewModel> popularItemViewModels = new ArrayList<>();
        for (int i = 0; i < repoList.size(); i++) {
            popularItemViewModels.add(new PopularItemViewModel(
                    ApiEndPoint.ENDPOINT_MOVIES_IMAGES.toString() + repoList.get(i).poster_path,
                    repoList.get(i).title,
                    repoList.get(i).overview, repoList.get(i).poster_path));
        }
        return popularItemViewModels;
    }

    public void fetchTopRatedRepo(String searching) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getAllLocalTopRated()
                .flatMap((Function<List<TopRatedMovie>, ObservableSource<TopRatedMovie>>) questions -> {
                    //Converts an sequence into an ObservableSource that emits the items in the sequence
                    return Observable.fromIterable(questions);
                })
                .filter(movie -> movie.title.contains(searching))
                .toList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(popularMovies -> {
                    if (popularMovies != null && popularMovies != null) {
                        topRatedItemsLiveData.setValue(getTopRatedViewModelList(popularMovies));
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }


    public List<PopularItemViewModel> getTopRatedViewModelList(List<TopRatedMovie> repoList) {
        ArrayList<PopularItemViewModel> topRatedItemViewModels = new ArrayList<>();
        for (int i = 0; i < repoList.size(); i++) {
            topRatedItemViewModels.add(new PopularItemViewModel(
                    ApiEndPoint.ENDPOINT_MOVIES_IMAGES.toString() + repoList.get(i).poster_path,
                    repoList.get(i).title,
                    repoList.get(i).overview, repoList.get(i).poster_path));
        }
        return topRatedItemViewModels;
    }

    public void fetchUpcomingRepo(String searching) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getAllLocalUpcoming()
                .flatMap((Function<List<UpcomingMovie>, ObservableSource<UpcomingMovie>>) questions -> {
                    //Converts an sequence into an ObservableSource that emits the items in the sequence
                    return Observable.fromIterable(questions);
                })
                .filter(movie -> movie.title.contains(searching))
                .toList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(upcomingMovies -> {
                    if (upcomingMovies != null && upcomingMovies != null) {
                        upcomingItemsLiveData.setValue(getUpcomingViewModelList(upcomingMovies));
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }


    public List<PopularItemViewModel> getUpcomingViewModelList(List<UpcomingMovie> repoList) {
        ArrayList<PopularItemViewModel> upcomingItemViewModels = new ArrayList<>();
        for (int i = 0; i < repoList.size(); i++) {
            upcomingItemViewModels.add(new PopularItemViewModel(
                    ApiEndPoint.ENDPOINT_MOVIES_IMAGES.toString() + repoList.get(i).poster_path,
                    repoList.get(i).title,
                    repoList.get(i).overview, repoList.get(i).poster_path));
        }
        return upcomingItemViewModels;
    }

    public MutableLiveData<List<PopularItemViewModel>> getPopularRepos() {
        return popularItemsLiveData;
    }

    public MutableLiveData<List<PopularItemViewModel>> getTopRatedRepos() {
        return topRatedItemsLiveData;
    }

    public MutableLiveData<List<PopularItemViewModel>> getUpcomingRepos() {
        return upcomingItemsLiveData;
    }

    public void addPopularItemsToList(List<PopularItemViewModel> popularItems) {
        popularItemViewModels.clear();
        popularItemViewModels.addAll(popularItems);
    }

    public void addTopRatedItemsToList(List<PopularItemViewModel> topRatedItems) {
        topRatedItemViewModels.clear();
        topRatedItemViewModels.addAll(topRatedItems);
    }

    public void addUpcomingItemsToList(List<PopularItemViewModel> upcomingItems) {
        upcomingItemViewModels.clear();
        upcomingItemViewModels.addAll(upcomingItems);
    }

    public ObservableArrayList<PopularItemViewModel> getPopularItemViewModels() {
        return popularItemViewModels;
    }

    public ObservableArrayList<PopularItemViewModel> getTopRatedItemViewModels() {
        return topRatedItemViewModels;
    }

    public ObservableArrayList<PopularItemViewModel> getUpcomingItemViewModels() {
        return upcomingItemViewModels;
    }

}
