package tomaszkopacz.meetbam.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\r\u0010\u000b\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\nH\u0001\u00a2\u0006\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Ltomaszkopacz/meetbam/di/FirebaseModule;", "", "()V", "provideAuthService", "Ltomaszkopacz/meetbam/interactor/AuthService;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "provideDatabaseService", "Ltomaszkopacz/meetbam/interactor/DatabaseService;", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "provideFirebaseAuth", "provideFirebaseAuth$app_debug", "provideFirebaseDatabase", "provideFirebaseDatabase$app_debug", "app_debug"})
@dagger.Module()
public final class FirebaseModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.google.firebase.auth.FirebaseAuth provideFirebaseAuth$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final tomaszkopacz.meetbam.interactor.AuthService provideAuthService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.google.firebase.database.FirebaseDatabase provideFirebaseDatabase$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final tomaszkopacz.meetbam.interactor.DatabaseService provideDatabaseService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.FirebaseDatabase database) {
        return null;
    }
    
    public FirebaseModule() {
        super();
    }
}