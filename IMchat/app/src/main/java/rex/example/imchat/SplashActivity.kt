package rex.example.imchat

import android.os.Handler
import android.util.Log
import rex.example.imchat.contract.SplashContract
import org.jetbrains.anko.startActivity
import rex.example.imchat.presenter.SplashPresenter


class SplashActivity : BaseActivity(), SplashContract.View{
    val TAG = "Splash"
    val presenter = SplashPresenter(this)
    companion object{
        val DELAY = 2000L
    }
    val handler by lazy {
        Handler()
    }

    override fun init() {
        super.init()
        presenter.checkLoginStatus()
        Log.d(TAG,"Check login Status")
    }
    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }
    // 延时两秒并跳转到登录界面
    override fun onNotLoggedIn() {
        handler.postDelayed({
            Log.d(TAG,"start Login Activity in 2s")
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