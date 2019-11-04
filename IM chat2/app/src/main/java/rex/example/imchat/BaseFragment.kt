package rex.example.imchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }
    open fun init(){
        //初始化公共功能，可复写
    }

    abstract fun getLayoutResId(): Int

}