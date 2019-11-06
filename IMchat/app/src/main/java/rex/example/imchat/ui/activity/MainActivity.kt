package rex.example.imchat.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rex.example.imchat.R

class MainActivity : BaseActivity() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        super.init()
        bottomBar.setOnTabSelectListener { tabId ->
            val beginTransation = supportFragmentManager.beginTransaction()

        }
    }
    
}
