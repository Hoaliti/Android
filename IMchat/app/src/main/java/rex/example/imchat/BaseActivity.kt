package rex.example.imchat

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

abstract class BaseActivity:AppCompatActivity(){
    val progressDialog by lazy {
        ProgressDialog(this)
    }

    //隐藏键盘
    val inputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        init()
    }
    open fun init(){
        //初始化一些公共的功能，子类也可复写来自己初始化
    }
    //子类必须实现该方法 并返回一个布局资源的ID
    abstract fun getLayoutResId():Int

    fun showProgress(message:String){
        progressDialog.setMessage(message)
        progressDialog.show()
    }

    fun dismissProgress(){
        progressDialog.dismiss()
    }

    fun hideSoftKeyboard(){
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken,0)
    }

}