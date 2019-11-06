package rex.example.imchat.ui.fragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import rex.example.imchat.R

class DynamicFragment :BaseFragment(){
    override fun getLayoutResId(): Int {
        return R.layout.fragment_dynamic
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.dynamic)

        val logoutString = String.format(getString(R.string.logout), FirebaseAuth.getInstance().currentUser!!.email)
        logout.text = logoutString
    }
}