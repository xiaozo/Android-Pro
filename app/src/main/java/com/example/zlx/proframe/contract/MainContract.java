package com.example.zlx.proframe.contract;


import com.example.zlx.proframe.base.BaseView;
import com.example.zlx.proframe.bean.BaseObjectBean;
import com.example.zlx.proframe.bean.LoginBean;
import com.example.zlx.proframe.bean.LoginParams;
import com.example.zlx.proframe.net.HttpResult;

import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.Observer;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface MainContract {
    interface Model {
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);

        Flowable<BaseObjectBean<LoginBean>> login1(LoginParams loginParams);

        Flowable<Object> test();

    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void login(String username, String password,HttpResult<LoginBean> httpResult);

        /**
         * 登陆
         *
         *
         */
        void login1(LoginParams loginParams,HttpResult<LoginBean> httpResult);
    }
}
