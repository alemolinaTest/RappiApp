package com.test.molina.rappiapp.ui.popular;

/**
 * Created by Amolina on 02/02/17.
 */

public class PopularEmptyItemViewModel {

    private PopularEmptyItemViewModelListener mListener;

    public PopularEmptyItemViewModel(PopularEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface PopularEmptyItemViewModelListener {
        void onRetryClick();
    }
}
