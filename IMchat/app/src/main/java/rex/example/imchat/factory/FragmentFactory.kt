package rex.example.imchat.factory

import android.util.Log
import androidx.fragment.app.Fragment
import rex.example.imchat.R
import rex.example.imchat.ui.fragment.ContactFragment
import rex.example.imchat.ui.fragment.ConversationFragment
import rex.example.imchat.ui.fragment.DynamicFragment

class FragmentFactory private constructor(){
    val conversation by lazy {
        ConversationFragment()
    }
    val contact by lazy {
        ContactFragment()
    }
    val dynamic by lazy {
        DynamicFragment()
    }

    companion object{
        val instance = FragmentFactory()
    }

    fun getFragment(tabId : Int):Fragment?{
        when(tabId){
            R.id.tab_conversation -> return conversation
            R.id.tab_contacts -> return contact
            R.id.tab_dynamic -> {
                println("切换到dynamic")
                return dynamic
            }
        }
        return null
    }
}