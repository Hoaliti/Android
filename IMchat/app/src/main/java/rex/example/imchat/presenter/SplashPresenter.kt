package rex.example.imchat.presenter

import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import rex.example.imchat.contract.SplashContract

class SplashPresenter(val view:SplashContract.View) : SplashContract.Presenter{
    override fun checkLoginStatus() {
        if(isLoggedIn()){
            view.onLoggedIn()
        }else{
            view.onNotLoggedIn()
        }
    }

    private fun isLoggedIn(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }
}