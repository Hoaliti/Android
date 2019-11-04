package rex.example.imchat

import android.os.Handler
import rex.example.imchat.contract.SplashContract
import org.jetbrains.anko.startActivity


class SplashActivity : BaseActivity(), SplashContract.View{
    companion object{
        val DELAY = 2000L
    }
    val handler by lazy {
        Handler()
    }
    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }
    // 延时两秒并跳转到登录界面
    override fun onNotLoggedIn() {
        handler.postDelayed({
            startActivity<LoginActivity>()
            finish()
        },DELAY)
    }
    //跳转到主界面
    override fun onLoggedIn() {
        startActivity<MainActivity>()
        finish()
    }
}