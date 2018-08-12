package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t*\u0002\f\u000f\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001d\u001a\u00020\u0018J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter;", "", "activity", "Ltomaszkopacz/meetbam/view/LoginActivity;", "(Ltomaszkopacz/meetbam/view/LoginActivity;)V", "authService", "Ltomaszkopacz/meetbam/interactor/AuthService;", "getAuthService", "()Ltomaszkopacz/meetbam/interactor/AuthService;", "setAuthService", "(Ltomaszkopacz/meetbam/interactor/AuthService;)V", "loginListener", "tomaszkopacz/meetbam/presenter/LoginActivityPresenter$loginListener$1", "Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter$loginListener$1;", "registerListener", "tomaszkopacz/meetbam/presenter/LoginActivityPresenter$registerListener$1", "Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter$registerListener$1;", "webService", "Ltomaszkopacz/meetbam/interactor/WebService;", "getWebService", "()Ltomaszkopacz/meetbam/interactor/WebService;", "setWebService", "(Ltomaszkopacz/meetbam/interactor/WebService;)V", "attemptLogin", "", "mail", "", "password", "attemptRegister", "confirmUserIsSignedIn", "goToMainActivity", "goToPersonalisationActivity", "submitLoginInput", "submitRegisterInput", "Companion", "app_debug"})
public final class LoginActivityPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.WebService webService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.AuthService authService;
    private final tomaszkopacz.meetbam.interactor.LoginListener loginListener = null;
    private final tomaszkopacz.meetbam.interactor.RegisterListener registerListener = null;
    private final tomaszkopacz.meetbam.view.LoginActivity activity = null;
    public static final int ERROR_MAIL_EMPTY = 10;
    public static final int ERROR_PASSWORD_EMPTY = 11;
    public static final int ERROR_MAIL_INVALID = 12;
    public static final int ERROR_PASSWORD_TOO_SHORT = 13;
    public static final int LOGIN_FAILED = -1;
    public static final int FAIL_NO_SUCH_MAIL = 14;
    public static final int FAIL_PASSWORD_WRONG = 15;
    public static final int REGISTER_FAILED = -2;
    public static final int ERROR_MAIL_OCCUPIED = 16;
    public static final tomaszkopacz.meetbam.presenter.LoginActivityPresenter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.WebService getWebService() {
        return null;
    }
    
    public final void setWebService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.WebService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.AuthService getAuthService() {
        return null;
    }
    
    public final void setAuthService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.AuthService p0) {
    }
    
    public final void confirmUserIsSignedIn() {
    }
    
    public final void submitLoginInput(@org.jetbrains.annotations.NotNull()
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void attemptLogin(java.lang.String mail, java.lang.String password) {
    }
    
    public final void submitRegisterInput(@org.jetbrains.annotations.NotNull()
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void attemptRegister(java.lang.String mail, java.lang.String password) {
    }
    
    private final void goToMainActivity() {
    }
    
    private final void goToPersonalisationActivity() {
    }
    
    public LoginActivityPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.LoginActivity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter$Companion;", "", "()V", "ERROR_MAIL_EMPTY", "", "ERROR_MAIL_INVALID", "ERROR_MAIL_OCCUPIED", "ERROR_PASSWORD_EMPTY", "ERROR_PASSWORD_TOO_SHORT", "FAIL_NO_SUCH_MAIL", "FAIL_PASSWORD_WRONG", "LOGIN_FAILED", "REGISTER_FAILED", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}