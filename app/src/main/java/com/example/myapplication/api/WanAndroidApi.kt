package com.example.myapplication.api

import com.example.myapplication.requestbean.LoginRequestBean
import com.xiangxue.kotlinproject.entity.LoginResponse
import com.xiangxue.kotlinproject.entity.LoginResponseWrapper
import io.reactivex.Observable

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//客户端api 可以访问 服务器的api
interface WanAndroidApi {
    /**
     * 登录api
     * username = "???"
     * pasword = "?????"
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(@Field("username") username: String,
                    @Field("password") password: String)
            : Observable<LoginResponseWrapper<LoginResponse>> // 返回值

}