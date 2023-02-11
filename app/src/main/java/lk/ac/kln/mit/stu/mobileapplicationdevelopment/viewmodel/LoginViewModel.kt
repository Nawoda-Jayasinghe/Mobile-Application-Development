package lk.ac.kln.mit.stu.mobileapplicationdevelopment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

import lk.ac.kln.mit.stu.mobileapplicationdevelopment.util.*



@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
//    private val db: FirebaseFirestore
): ViewModel() {
    private val _login = MutableSharedFlow<lk.ac.kln.mit.stu.mobileapplicationdevelopment.util.Resource<FirebaseUser>>()

    //private val _login = MutableSharedFlow<Resource<FirebaseUser>>()
    val login = _login.asSharedFlow()

    fun login(email: String, password: String){

        viewModelScope.launch {
            _login.emit(lk.ac.kln.mit.stu.mobileapplicationdevelopment.util.Resource.Loading())
        }

        firebaseAuth.signInWithEmailAndPassword(
            email,password
        ).addOnSuccessListener {
            viewModelScope.launch {
                it.user?.let {
                    _login.emit(lk.ac.kln.mit.stu.mobileapplicationdevelopment.util.Resource.Success(it))
                }
            }
        }.addOnFailureListener {
            viewModelScope.launch {
                _login.emit(lk.ac.kln.mit.stu.mobileapplicationdevelopment.util.Resource.Error(it.message.toString()))
            }
        }
    }

}