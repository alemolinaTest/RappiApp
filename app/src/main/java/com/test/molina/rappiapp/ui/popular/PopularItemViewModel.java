package com.test.molina.rappiapp.ui.popular;

import android.databinding.ObservableField;

/**
 * Created by Amolina on 02/02/17.
 */

public class PopularItemViewModel {

    public ObservableField<String> getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(ObservableField<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public void setTitle(ObservableField<String> title) {
        this.title = title;
    }

    public ObservableField<String> getContent() {
        return content;
    }

    public void setContent(ObservableField<String> content) {
        this.content = content;
    }

    public ObservableField<String> getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(ObservableField<String> projectUrl) {
        this.projectUrl = projectUrl;
    }

    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> projectUrl = new ObservableField<>();

    public PopularItemViewModel(String imageUrl, String title, String content, String projectUrl) {
        this.imageUrl.set(imageUrl);
        this.title.set(title);
        this.content.set(content);
        this.projectUrl.set(projectUrl);
    }

}
