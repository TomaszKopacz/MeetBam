package tomaszkopacz.meetbam.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.interactor.DatabaseService
import tomaszkopacz.meetbam.interactor.StorageService
import javax.inject.Singleton

@Module
class FirebaseModule {

    @Provides
    @Singleton
    internal fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthService(auth: FirebaseAuth): AuthService {
        return AuthService(auth)
    }

    @Provides
    @Singleton
    internal fun provideFirebaseDatabase(): FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideDatabaseService(database: FirebaseDatabase): DatabaseService{
        return DatabaseService(database)
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideStorageService(firebaseStorage: FirebaseStorage): StorageService{
        return StorageService(firebaseStorage)
    }
}