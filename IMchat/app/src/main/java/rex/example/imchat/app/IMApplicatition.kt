package rex.example.imchat.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

class IMApplicatition : Application(){
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)

    }
}