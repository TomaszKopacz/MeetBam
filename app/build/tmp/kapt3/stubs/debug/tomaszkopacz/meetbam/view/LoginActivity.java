package tomaszkopacz.meetbam.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Ltomaszkopacz/meetbam/view/LoginActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "presenter", "Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter;", "checkInput", "", "state", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showError", "error", "Companion", "app_debug"})
public final class LoginActivity extends android.support.v7.app.AppCompatActivity {
    private tomaszkopacz.meetbam.presenter.LoginActivityPresenter presenter;
    public static final int LOGIN_LAYOUT = 1;
    public static final int REGISTER_LAYOUT = 2;
    public static final tomaszkopacz.meetbam.view.LoginActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkInput(int state) {
    }
    
    public final void showError(int error) {
    }
    
    public LoginActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Ltomaszkopacz/meetbam/view/LoginActivity$Companion;", "", "()V", "LOGIN_LAYOUT", "", "REGISTER_LAYOUT", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}