package com.bawei.lixinzhoukao.presenter;

import android.util.Log;

import com.bawei.lixinzhoukao.model.NewUstil;

public class PresenterImpl extends HomePresenter.Ipresenter {
    private static final String TAG = "PresenterImpl";
    protected  IBaseView iBaseView;
    public PresenterImpl(IBaseView iBaseView) {
        super(iBaseView);
        this.iBaseView=iBaseView;
    }

    @Override
    public void getDDaa(String path) {
        NewUstil.getInstance().doGet(path, new NewUstil.ICallBack() {
            @Override
            public void onCheng(Object obj) {
                Log.d(TAG, "onCheng: ");
                if (iBaseView != null) {
                    iBaseView.onCheng(obj);
                }
            }

            @Override
            public void onShi(String meg) {
                Log.d(TAG, "onShi: ");
                if (iBaseView != null) {
                    iBaseView.onShi(meg);
                }
            }
        });
    }
}
