package rex.example.imchat

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import rex.example.imchat.contract.LoginContract

class LoginActivity : BaseActivity(),LoginContract.View{
    override fun onUserNameError() {
        userName.error = getString(R.string.user_name_error)
    }

    override fun onPasswordError() {
        password.error = getString(R.string.password_error)
    }

    override fun onStartLogin() {
        // 弹出进度条
        showProgress(getString(R.string.logging))
    }

    override fun onLoggedInSuccess() {
        // 隐藏进度条
        dismissProgress()
        // 进入主界面
        startActivity<MainActivity>()
        // 退出loginActivity
        finish()
    }

    override fun onLoggedInFailed() {
        // 隐藏进度条
        dismissProgress()
        //弹出toast
        toast(R.string.login_failed)
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

}