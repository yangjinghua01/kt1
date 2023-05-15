package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.api.WanAndroidApi
import com.xiangxue.kotlinproject.entity.LoginResponse
import com.xiangxue.kotlinproject.net.APIClient
import com.xiangxue.kotlinproject.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user_login.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        user_login_bt.setOnClickListener(onCLickLister)
    }
    private val onCLickLister = View.OnClickListener { view ->
        // id = 内部根据= 知道你是 要 setId，  否则就是getId
        when(view.id) {
            // 登录
            R.id.user_login_bt -> {

                val userNameStr = user_phone_et.text.toString()
                val userPwdStr = user_password_et.text.toString()
                Log.d("TAG", "userName:$userNameStr,  userPwd:$userPwdStr")

                APIClient.instance.instanceRetrofit(WanAndroidApi::class.java)

                    // 全部都是RxJava知识了
                    .loginAction(userNameStr, userPwdStr)  // 起点  往下流  ”包装Bean“
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
                    /*.subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
                            override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                                // 我这里是更新UI，拿到了包装Bean，实际上我不需要包装Bean
                            }

                        })*/

                    .subscribe(object: APIResponse<LoginResponse>(this)
                    {
                        override fun success(data: LoginResponse ?) {
                            // 成功  data UI
                            Log.e("TAG", "success: $data")
                            Toast.makeText(this@MainActivity, "登录成功😀", Toast.LENGTH_SHORT).show()
                        }

                        override fun failure(errorMsg: String?) {
                            // 失败 msg UI
                            Log.e("TAG", "failure: errorMsg:$errorMsg")
                            Toast.makeText(this@MainActivity, "登录失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
                        }

                    })
            }

            // else->

        }
    }
}




