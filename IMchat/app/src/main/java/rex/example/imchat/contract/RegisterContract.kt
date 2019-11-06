package rex.example.imchat.contract

import com.google.firebase.auth.FirebaseAuth

interface RegisterContract {
    interface Presenter:BasePresenter{
        fun register(userName:String,password:String,confirmPassword:String,auth: FirebaseAuth)
    }

    interface View{
        fun onUserNameError()
        fun onPasswordError()
        fun onConfirmPasswordError()
        fun onStartRegister()
        fun onRegisterSuccess()
        fun onRegisterFailed()
    }
}