package com.test.molina.rappiapp.ui.popular;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.test.molina.rappiapp.BR;
import com.test.molina.rappiapp.R;
import com.test.molina.rappiapp.databinding.FragmentPopularBinding;
import com.test.molina.rappiapp.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Amolina on 02/02/17.
 */

public class PopularFragment extends BaseFragment<FragmentPopularBinding, PopularViewModel> implements PopularNavigator, PopularAdapter.PopularAdapterListener {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    LinearLayoutManager mLayoutManager;

    private PopularViewModel mPopularViewModel;
    FragmentPopularBinding mFragmentPopularBinding;
    private int mMode;

    private PopularAdapter adapter;

    public static PopularFragment newInstance(int mode) {
        Bundle args = new Bundle();
        args.putInt("MODE", mode);
        PopularFragment fragment = new PopularFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mMode = bundle.getInt("MODE");
        mPopularViewModel.setNavigator(this);
        adapter = new PopularAdapter();
        adapter.setListener(this);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentPopularBinding = getViewDataBinding();
        getViewModel();
        setUp();
        switch (mMode) {
            case 1:
                subscribeToPopularLiveData();
                break;
            case 2:
                subscribeToTopRatedLiveData();
                break;
            case 3:
                subscribeToUpcomingLiveData();
                break;
        }

    }


    private void subscribeToPopularLiveData() {
        mPopularViewModel.getPopularRepos().observe(this, PopularItemViewModels -> {
            mPopularViewModel.addPopularItemsToList(PopularItemViewModels);
            setAdapterData(mPopularViewModel.getPopularItemViewModels());
        });
    }

    private void subscribeToTopRatedLiveData() {
        mPopularViewModel.getTopRatedRepos().observe(this, TopRateItemViewModels -> {
            mPopularViewModel.addTopRatedItemsToList(TopRateItemViewModels);
            setAdapterData(mPopularViewModel.getTopRatedItemViewModels());
        });
    }

    private void subscribeToUpcomingLiveData() {
        mPopularViewModel.getUpcomingRepos().observe(this, UpcomingItemViewModels -> {
            mPopularViewModel.addUpcomingItemsToList(UpcomingItemViewModels);
            setAdapterData(mPopularViewModel.getUpcomingItemViewModels());
        });
    }

    @Override
    public PopularViewModel getViewModel() {
        mPopularViewModel = ViewModelProviders.of(getActivity(), mViewModelFactory).get(PopularViewModel.class);
        return mPopularViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_popular;
    }

    private void setUp() {


        if (adapter != null) {
            switch (mMode) {
                case 1:
                    setAdapterData(mPopularViewModel.getPopularItemViewModels());
                    break;
                case 2:
                    setAdapterData(mPopularViewModel.getTopRatedItemViewModels());
                    break;
                case 3:
                    setAdapterData(mPopularViewModel.getUpcomingItemViewModels());
                    break;
            }

        }
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentPopularBinding.popularRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentPopularBinding.popularRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentPopularBinding.popularRecyclerView.setAdapter(adapter);
    }


    private void setAdapterData(List<PopularItemViewModel> repoList) {
        adapter.clearItems();
        adapter.addItems(repoList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onRetryClick() {
        mPopularViewModel.fetchAll("");
    }
}
