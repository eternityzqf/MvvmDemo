package com.ken.mvvmdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import it.sephiroth.android.library.picasso.Picasso;

public class User extends BaseObservable {

    private String name;
    private String password;
    private String headimg;

    public User(String name, String password, String img) {
        this.name = name;
        this.password = password;
        this.headimg = img;
    }

    @BindingAdapter("bind:headimg")
    public static void getHeader(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        notifyPropertyChanged(BR.name);
        this.name = name;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        notifyPropertyChanged(BR.password);
        this.password = password;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }
}
