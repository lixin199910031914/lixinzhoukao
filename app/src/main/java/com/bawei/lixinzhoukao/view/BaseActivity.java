package com.bawei.lixinzhoukao.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.lixinzhoukao.presenter.BasePresenter;
import com.bawei.lixinzhoukao.presenter.PresenterImpl;

public abstract class BaseActivity extends AppCompatActivity {
    protected PresenterImpl presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if (initLayout()!=0){
            setContentView(initLayout());
            initView();
            initPresenter();
            initData();
        }

    }

    protected abstract void initData();

    protected abstract BasePresenter initPresenter();

    protected abstract void initView();

    protected abstract int initLayout();
}
