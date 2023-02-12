package lk.ac.kln.mit.stu.mobileapplicationdevelopment.di
//dependency injection
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //stay all instances alive
object AppModule {
    @Provides //as we provide new dependencies
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance() //this is injected later to view models

    //firebase dependencies
    @Provides
    @Singleton
    fun provideFirebaseFirestoreDatabase() = Firebase.firestore
}