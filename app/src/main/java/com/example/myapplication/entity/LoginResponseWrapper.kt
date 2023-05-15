package com.xiangxue.kotlinproject.entity

data class LoginResponseWrapper<T>(val data: T, val errorCode: Int, val errorMsg: String)