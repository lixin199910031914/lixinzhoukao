package com.bawei.lixinzhoukao.view;

import android.widget.ListView;

import com.bawei.lixinzhoukao.R;
import com.bawei.lixinzhoukao.app.Api;
import com.bawei.lixinzhoukao.model.Bean;
import com.bawei.lixinzhoukao.model.ListAdapter;
import com.bawei.lixinzhoukao.presenter.BasePresenter;
import com.bawei.lixinzhoukao.presenter.HomePresenter;
import com.bawei.lixinzhoukao.presenter.PresenterImpl;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements HomePresenter.Iview {


    private ListView list;

    @Override
    protected void initData() {

            presenter= (PresenterImpl) initPresenter();
            presenter.getDDaa(Api.PATH);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl(this);
    }

    @Override
    protected void initView() {
        list = findViewById(R.id.list);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCheng(Object obj) {
        Gson gson=new Gson();
        Bean bean = gson.fromJson(obj.toString(), Bean.class);
        List<Bean.BeanData> data = bean.getData();
        ListAdapter adapter=new ListAdapter(data,MainActivity.this);
        list.setAdapter(adapter);
    }

    @Override
    public void onShi(String meg) {

    }
}
