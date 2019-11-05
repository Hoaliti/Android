package rex.example.imchat.presenter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
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
            }else{
                view.onPasswordError()
            }
        }else{
            view.onUserNameError()
        }
    }
}