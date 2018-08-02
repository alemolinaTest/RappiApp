package com.test.molina.rappiapp.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.test.molina.rappiapp.ui.popular.PopularAdapter;
import com.test.molina.rappiapp.ui.popular.PopularItemViewModel;

import java.util.ArrayList;


/**
 * Created by Amolina on 02/02/17.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    @BindingAdapter({"adapter"})
    public static void addPopularItems(RecyclerView recyclerView,
                                          ArrayList<PopularItemViewModel> popularItems) {
        PopularAdapter adapter = (PopularAdapter) recyclerView.getAdapter();
        if(adapter != null) {
            adapter.clearItems();
            adapter.addItems(popularItems);
        }
    }



}
