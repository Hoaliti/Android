package rex.example.imchat.ui.fragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.support.v4.progressDialog
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import rex.example.imchat.R
import rex.example.imchat.ui.activity.LoginActivity

class DynamicFragment :BaseFragment(){
    override fun getLayoutResId(): Int {
        return R.layout.fragment_dynamic
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.dynamic)

        val logoutString = String.format(getString(R.string.logout), FirebaseAuth.getInstance().currentUser!!.email)
        logout.text = logoutString

        logout.setOnClickListener {
            logout()
        }
    }

    private fun logout(){
        FirebaseAuth.getInstance().signOut()
        context!!.runOnUiThread {
            toast(R.string.logout_success)
            this.startActivity<LoginActivity>()
            activity!!.finish()
        }


    }
}