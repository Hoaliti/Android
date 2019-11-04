package rex.example.imchat.contract

interface SplashContract {
    interface Presenter:BasePresenter{
        fun checkLoginStatus()//检查登陆状态
    }

    interface View{
        fun onNotLoggedIn()//没有登陆的ui处理
        fun  onLoggedIn()//登陆后的ui处理
    }
}