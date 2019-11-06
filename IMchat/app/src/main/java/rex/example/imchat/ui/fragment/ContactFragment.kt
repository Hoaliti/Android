package rex.example.imchat.ui.fragment

import android.graphics.Color
import android.view.View
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*
import rex.example.imchat.R

class ContactFragment : BaseFragment(){
    override fun getLayoutResId(): Int {
        return R.layout.fragment_contacts
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE
        swipeRefreshLayout.apply {
            swipeRefreshLayout.setColorSchemeColors(Color.BLUE)
            isRefreshing = true
        }

    }
}
