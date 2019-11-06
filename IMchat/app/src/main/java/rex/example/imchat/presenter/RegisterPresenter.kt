package rex.example.imchat.presenter

import android.content.Context
import android.provider.ContactsContract
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.jetbrains.anko.doAsync
import rex.example.imchat.contract.RegisterContract
import rex.example.imchat.extentions.isValidPassword
import rex.example.imchat.extentions.isValidUserName
import java.lang.Exception
import com.google.firebase.database.DatabaseError



class RegisterPresenter(val view:RegisterContract.View) : RegisterContract.Presenter{
    override fun register(userName: String, password: String,confirmPassword:String,auth: FirebaseAuth) {
        if(userName.isValidUserName()){
            //检查密码
            if(password.isValidPassword()){
                if(password.equals(confirmPassword)){
                    //密码确认一致
                    view.onStartRegister()
                    //开始注册
                    registerFirebase(userName,password,auth)
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

    private fun registerFirebase(userName: String, password: String,auth: FirebaseAuth) {
        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")
        doAsync {
            auth.createUserWithEmailAndPassword(userName, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val uid: String = auth.currentUser!!.uid
                    val database = reference.child(uid)
                    val hashMap = HashMap<String, String>()
                    hashMap["id"] = uid
                    hashMap["userName"] = userName
                    hashMap["password"] = password
                    database.setValue(hashMap)
                    view.onRegisterSuccess()
                } else {
                    if(it.exception is FirebaseAuthUserCollisionException){
                        view.onUserAlreadyTaken()
                    }else{
                        view.onRegisterFailed()
                    }
                }
            }
        }
    }

}