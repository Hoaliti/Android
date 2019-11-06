package rex.example.imchat.presenter

import rex.example.imchat.contract.RegisterContract
import rex.example.imchat.extentions.isValidPassword
import rex.example.imchat.extentions.isValidUserName

class RegisterPresenter(val view:RegisterContract.View) : RegisterContract.Presenter{
    override fun register(userName: String, password: String,confirmPassword:String) {
        if(userName.isValidUserName()){
            //检查密码
            if(password.isValidPassword()){
                if(password.equals(confirmPassword)){
                    //密码确认一致
                    view.onStartRegister()
                    //开始注册
                }else{
                    view.onConfirmPasswordError()
                }
            }else{
                view.onPasswordError()
            }
        }else{
            view.onUserNameError()
        }
    }
}