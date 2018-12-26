package com.ken.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ken.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    UserField userField = new UserField();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final User user = new User("张三", "123456", "http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg");
        mainBinding.setUser(user);
        mainBinding.setField(userField);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                user.setName("李四");
//                user.setPassword("123");
                userField.name.set("李四");
                userField.password.set("123");


            }
        }, 2000);
    }
}
