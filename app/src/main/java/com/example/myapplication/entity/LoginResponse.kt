package com.xiangxue.kotlinproject.entity
data class LoginResponse(val admin: Boolean,
                         val chapterTops: List<*>,
                         val collectIds: List<*>,
                         val email: String ?,
                         val icon: String?,
                         val id: String?,
                         val nickname: String?,
                         val password: String?,
                         val publicName: String?,
                         val token: String?,
                         val type: Int,
                         val username: String?
                         )