package tomaszkopacz.meetbam.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\bJ \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Ltomaszkopacz/meetbam/interactor/AuthService;", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "getCurrentUser", "Lcom/google/firebase/auth/FirebaseUser;", "loginUser", "", "mail", "", "password", "listener", "Ltomaszkopacz/meetbam/interactor/LoginListener;", "logout", "registerUser", "Ltomaszkopacz/meetbam/interactor/RegisterListener;", "app_debug"})
public final class AuthService {
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    
    public final void loginUser(@org.jetbrains.annotations.NotNull()
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    tomaszkopacz.meetbam.interactor.LoginListener listener) {
    }
    
    public final void registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    tomaszkopacz.meetbam.interactor.RegisterListener listener) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.auth.FirebaseUser getCurrentUser() {
        return null;
    }
    
    public final void logout() {
    }
    
    public AuthService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth) {
        super();
    }
}