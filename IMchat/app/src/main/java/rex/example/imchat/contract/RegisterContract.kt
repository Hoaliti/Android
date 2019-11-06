package rex.example.imchat.contract

interface RegisterContract {
    interface Presenter:BasePresenter{
        fun register(userName:String,password:String)
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