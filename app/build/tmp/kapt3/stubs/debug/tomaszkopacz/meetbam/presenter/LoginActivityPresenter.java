package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter;", "", "activity", "Ltomaszkopacz/meetbam/view/LoginActivity;", "(Ltomaszkopacz/meetbam/view/LoginActivity;)V", "mLoginService", "Ltomaszkopacz/meetbam/service/LoginService;", "getMLoginService", "()Ltomaszkopacz/meetbam/service/LoginService;", "setMLoginService", "(Ltomaszkopacz/meetbam/service/LoginService;)V", "webService", "Ltomaszkopacz/meetbam/interactor/WebService;", "getWebService", "()Ltomaszkopacz/meetbam/interactor/WebService;", "setWebService", "(Ltomaszkopacz/meetbam/interactor/WebService;)V", "attemptLogin", "", "mail", "", "password", "confirmUserIsSignedIn", "goToMainActivity", "login", "user", "Ltomaszkopacz/meetbam/entity/User;", "submitInput", "updateUserLoggedOnDevice", "Companion", "UserLoginTask", "app_debug"})
public final class LoginActivityPresenter {
    @org.jetbrains.annotations.NotNull()
    private tomaszkopacz.meetbam.service.LoginService mLoginService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.WebService webService;
    private final tomaszkopacz.meetbam.view.LoginActivity activity = null;
    private static final int LOGIN_FAILED = -1;
    private static final int MAIL_EMPTY = 10;
    private static final int PASSWORD_EMPTY = 11;
    private static final int MAIL_INVALID = 12;
    private static final int PASSWORD_TOO_SHORT = 13;
    private static final int NO_SUCH_MAIL = 14;
    private static final int PASSWORD_WRONG = 15;
    public static final tomaszkopacz.meetbam.presenter.LoginActivityPresenter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.service.LoginService getMLoginService() {
        return null;
    }
    
    public final void setMLoginService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.service.LoginService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.WebService getWebService() {
        return null;
    }
    
    public final void setWebService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.WebService p0) {
    }
    
    public final void confirmUserIsSignedIn() {
    }
    
    public final void submitInput(@org.jetbrains.annotations.NotNull()
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void attemptLogin(java.lang.String mail, java.lang.String password) {
    }
    
    private final void login(tomaszkopacz.meetbam.entity.User user) {
    }
    
    private final void updateUserLoggedOnDevice(java.lang.String mail) {
    }
    
    private final void goToMainActivity() {
    }
    
    public LoginActivityPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.LoginActivity activity) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0083\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter$UserLoginTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "mEmail", "", "mPassword", "(Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter;Ljava/lang/String;Ljava/lang/String;)V", "user", "Ltomaszkopacz/meetbam/entity/User;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Boolean;", "onCancelled", "", "onPostExecute", "success", "(Ljava/lang/Boolean;)V", "app_debug"})
    final class UserLoginTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {
        private tomaszkopacz.meetbam.entity.User user;
        private final java.lang.String mEmail = null;
        private final java.lang.String mPassword = null;
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean success) {
        }
        
        @java.lang.Override()
        protected void onCancelled() {
        }
        
        public UserLoginTask(@org.jetbrains.annotations.NotNull()
        java.lang.String mEmail, @org.jetbrains.annotations.NotNull()
        java.lang.String mPassword) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter$Companion;", "", "()V", "LOGIN_FAILED", "", "getLOGIN_FAILED", "()I", "MAIL_EMPTY", "getMAIL_EMPTY", "MAIL_INVALID", "getMAIL_INVALID", "NO_SUCH_MAIL", "getNO_SUCH_MAIL", "PASSWORD_EMPTY", "getPASSWORD_EMPTY", "PASSWORD_TOO_SHORT", "getPASSWORD_TOO_SHORT", "PASSWORD_WRONG", "getPASSWORD_WRONG", "app_debug"})
    public static final class Companion {
        
        public final int getLOGIN_FAILED() {
            return 0;
        }
        
        public final int getMAIL_EMPTY() {
            return 0;
        }
        
        public final int getPASSWORD_EMPTY() {
            return 0;
        }
        
        public final int getMAIL_INVALID() {
            return 0;
        }
        
        public final int getPASSWORD_TOO_SHORT() {
            return 0;
        }
        
        public final int getNO_SUCH_MAIL() {
            return 0;
        }
        
        public final int getPASSWORD_WRONG() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}