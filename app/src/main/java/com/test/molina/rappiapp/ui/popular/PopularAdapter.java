package com.test.molina.rappiapp.ui.popular;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.molina.rappiapp.ui.base.BaseViewHolder;
import com.test.molina.rappiapp.databinding.ItemPopularViewBinding;
import com.test.molina.rappiapp.databinding.ItemPopularEmptyViewBinding;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */

public class PopularAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private List<PopularItemViewModel> mPopularResponseList;
    private PopularAdapterListener mListener;

    public PopularAdapter() {
        this.mPopularResponseList = new ArrayList<>();
    }

    public void setListener(PopularAdapterListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemPopularViewBinding popularViewBinding = ItemPopularViewBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new PopularViewHolder(popularViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemPopularEmptyViewBinding emptyViewBinding = ItemPopularEmptyViewBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mPopularResponseList != null && mPopularResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mPopularResponseList != null && mPopularResponseList.size() > 0) {
            return mPopularResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<PopularItemViewModel> repoList) {
        mPopularResponseList.addAll(repoList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mPopularResponseList.clear();
    }

    public class PopularViewHolder extends BaseViewHolder implements View.OnClickListener {

        private ItemPopularViewBinding mBinding;


        public PopularViewHolder(ItemPopularViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final PopularItemViewModel mPopularItemViewModel = mPopularResponseList.get(position);
            mBinding.setViewModel(mPopularItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }


        @Override
        public void onClick(View view) {
            if (mPopularResponseList.get(0).projectUrl.get() != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(mPopularResponseList.get(0).projectUrl.get()));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    Log.d("","url error");
                }
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements PopularEmptyItemViewModel.PopularEmptyItemViewModelListener {

        private ItemPopularEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemPopularEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            PopularEmptyItemViewModel emptyItemViewModel = new PopularEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

    public interface PopularAdapterListener {
        void onRetryClick();
    }
}