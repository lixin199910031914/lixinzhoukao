package com.bawei.lixinzhoukao.presenter;

public interface HomePresenter {
    interface  Iview extends IBaseView{}
    abstract  class  Ipresenter extends BasePresenter{
        public Ipresenter(IBaseView iBaseView) {
            super(iBaseView);
        }
        public  abstract  void  getDDaa(String path);
    }
}
