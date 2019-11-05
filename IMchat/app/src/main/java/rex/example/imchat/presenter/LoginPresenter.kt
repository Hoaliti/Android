package rex.example.imchat.presenter

import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseUser
import rex.example.imchat.contract.LoginContract
import rex.example.imchat.extentions.isValidPassword
import rex.example.imchat.extentions.isValidUserName

class LoginPresenter(val view:LoginContract.View) : LoginContract.Presenter{
    override fun login(userName: String, password: String) {
        if(userName.isValidUserName()){
            //用户名合法，继续校验密码
            if(password.isValidPassword()){
                //密码合法，开始登陆
                view.onStartLogin()
                // 登录到firebase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(userName,password)
                    .addOnCompleteListener (OnCompleteListener<AuthResult>() {
                        if(it.isSuccessful){

                            // 在主线程通知view层
                            uiThread { view.onLoggedInSuccess() }
                        }else{
                            uiThread { view.onLoggedInFailed() }
                        }
                    })
            }else{
                view.onPasswordError()
            }
        }else{
            view.onUserNameError()
        }
    }
}