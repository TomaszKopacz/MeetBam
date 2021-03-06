package tomaszkopacz.meetbam.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0011J\b\u0010\u0018\u001a\u00020\u0011H\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Ltomaszkopacz/meetbam/view/MainApp;", "Landroid/app/Application;", "()V", "<set-?>", "Ltomaszkopacz/meetbam/di/AppComponent;", "component", "getComponent", "()Ltomaszkopacz/meetbam/di/AppComponent;", "setComponent", "(Ltomaszkopacz/meetbam/di/AppComponent;)V", "prefs", "Ltomaszkopacz/meetbam/service/Preferences;", "getLoggedUser", "Ltomaszkopacz/meetbam/entity/User;", "isUserLoggedIn", "", "login", "", "mail", "", "name", "surname", "password", "logout", "onCreate", "app_debug"})
public final class MainApp extends android.app.Application {
    @org.jetbrains.annotations.Nullable()
    private tomaszkopacz.meetbam.di.AppComponent component;
    private tomaszkopacz.meetbam.service.Preferences prefs;
    
    @org.jetbrains.annotations.Nullable()
    public final tomaszkopacz.meetbam.di.AppComponent getComponent() {
        return null;
    }
    
    private final void setComponent(tomaszkopacz.meetbam.di.AppComponent p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String surname, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void logout() {
    }
    
    public final boolean isUserLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.entity.User getLoggedUser() {
        return null;
    }
    
    public MainApp() {
        super();
    }
}