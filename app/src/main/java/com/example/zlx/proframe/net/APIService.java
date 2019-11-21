package com.example.zlx.proframe.net;


import com.example.zlx.proframe.bean.BaseObjectBean;
import com.example.zlx.proframe.bean.LoginBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface APIService {

    /**
     * 登陆
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
//    @POST("user/login")
    @GET("")
    Flowable<BaseObjectBean<LoginBean>> login(@Field("username") String username,
                                              @Field("password") String password);

    /**
     * 登陆
     *
     * @return
     */
//    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseObjectBean<LoginBean>> login1(@Body RequestBody info);

//    @FormUrlEncoded
    @GET("/1.json")
    Flowable<Object> test();


}
