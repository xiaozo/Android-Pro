package com.example.zlx.proframe.model;

import com.alibaba.fastjson.JSON;
import com.example.zlx.proframe.base.BaseView;
import com.example.zlx.proframe.bean.BaseObjectBean;
import com.example.zlx.proframe.bean.LoginBean;
import com.example.zlx.proframe.bean.LoginParams;
import com.example.zlx.proframe.contract.MainContract;
import com.example.zlx.proframe.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class MainModel implements MainContract.Model {


    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username,password);
    }

    @Override
    public Flowable<BaseObjectBean<LoginBean>> login1(LoginParams loginParams) {
        String paramsStr = JSON.toJSONString(loginParams);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), paramsStr);
        return RetrofitClient.getInstance().getApi().login1(body);
    }

    @Override
    public Flowable<Object> test() {
        return RetrofitClient.getInstance().getApi().test();
    }

}
