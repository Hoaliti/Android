package rex.example.imchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(){
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
}