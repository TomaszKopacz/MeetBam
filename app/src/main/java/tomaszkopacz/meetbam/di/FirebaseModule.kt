package tomaszkopacz.meetbam.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebasAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}