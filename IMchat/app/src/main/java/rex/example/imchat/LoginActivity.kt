package rex.example.imchat

import android.content.pm.PackageManager
import android.view.KeyEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import rex.example.imchat.contract.LoginContract
import rex.example.imchat.presenter.LoginPresenter
import java.util.jar.Manifest

class LoginActivity : BaseActivity(),LoginContract.View{

    val presenter = LoginPresenter(this)

    override fun init() {
        super.init()
        newUser.setOnClickListener{
            startActivity<RegisterActivity>()
        }
        login.setOnClickListener{
            login()
        }
        password.setOnEditorActionListener { v, actionId, event ->
            login()
            true
        }
    }
    fun login(){
        hideSoftKeyboard()
        if(hasWriteExternalStoragePermission()){
            val userNameString = userName.text.trim().toString()
            val passwordString = password.text.trim().toString()

            presenter.login(userNameString,passwordString)
        }else{
            applyWriteExternalStoragePermission()
        }


    }
    //检查是否有写入磁盘的判断
    private fun hasWriteExternalStoragePermission():Boolean{
        val result = ActivityCompat.checkSelfPermission(this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun applyWriteExternalStoragePermission(){
        val permissions = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this,permissions,0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //用户同意权限
            login()
        }else{
            toast(R.string.permission_denied)
        }
    }
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