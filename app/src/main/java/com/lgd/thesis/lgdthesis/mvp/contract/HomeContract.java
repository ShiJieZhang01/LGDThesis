package com.lgd.thesis.lgdthesis.mvp.contract;

import com.lgd.thesis.lgdthesis.mvp.precenter.BasePresenter;
import com.lgd.thesis.lgdthesis.mvp.view.BaseMvpView;

/**
 * Created by admin on 17/4/12.
 */

public interface HomeContract {
    interface Presenter extends BasePresenter {
        void showName();

    }
    interface MvpView extends BaseMvpView<Presenter>{

    }
}
