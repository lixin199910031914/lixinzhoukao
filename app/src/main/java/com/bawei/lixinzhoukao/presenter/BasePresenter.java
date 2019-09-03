package com.bawei.lixinzhoukao.presenter;

public class BasePresenter  {
    protected  IBaseView iBaseView;

    public BasePresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
    }
    private void  onDrestroy(){
        if (iBaseView != null) {
            iBaseView=null;
        }
    }
}
