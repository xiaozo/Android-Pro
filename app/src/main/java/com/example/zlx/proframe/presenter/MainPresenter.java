package com.example.zlx.proframe.presenter;



import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.example.zlx.proframe.base.BasePresenter;
import com.example.zlx.proframe.bean.BaseObjectBean;
import com.example.zlx.proframe.bean.LoginBean;
import com.example.zlx.proframe.bean.LoginParams;
import com.example.zlx.proframe.contract.MainContract;
import com.example.zlx.proframe.model.MainModel;
import com.example.zlx.proframe.net.HttpResult;
import com.example.zlx.proframe.net.RetrofitClient;
import com.example.zlx.proframe.net.RxScheduler;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.RequestBody;

/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }


    public MainPresenter(MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void login(String username, String password, final HttpResult<LoginBean> httpResult) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();

        model.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.hideLoading();
//                        mView.onSuccess(bean);
                        httpResult.onSuccess(null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
//                        mView.onError(throwable);
                        httpResult.onError(throwable);

                    }
                });




    }

    @Override
    public void login1(LoginParams loginParams, final HttpResult<LoginBean> httpResult) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login1(loginParams)
                .compose(RxScheduler.<Object>Flo_io_main())
                .as(mView.<Object>bindAutoDispose())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mView.hideLoading();
                        //目前没写返回code校验 根据校验规则是否抛出异常
                        httpResult.onSuccess(null);
//                        test_cash();


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        httpResult.onError(throwable);

                    }
                });

    }

    public void test_cash(){
        throw new RuntimeException("初始化大小不能小于0:");
    }


}
