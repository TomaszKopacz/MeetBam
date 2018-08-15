package tomaszkopacz.meetbam.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Ltomaszkopacz/meetbam/view/AccountActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "app", "Ltomaszkopacz/meetbam/view/MainApp;", "getApp", "()Ltomaszkopacz/meetbam/view/MainApp;", "setApp", "(Ltomaszkopacz/meetbam/view/MainApp;)V", "mAccountFriendsFragment", "Ltomaszkopacz/meetbam/view/AccountFriendsFragment;", "mAccountInfoFragment", "Ltomaszkopacz/meetbam/view/AccountInfoFragment;", "mAccountPhotosFragment", "Ltomaszkopacz/meetbam/view/AccountPhotosFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setUpViewPager", "viewPager", "Landroid/support/v4/view/ViewPager;", "Companion", "app_debug"})
public final class AccountActivity extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private tomaszkopacz.meetbam.view.MainApp app;
    private tomaszkopacz.meetbam.view.AccountInfoFragment mAccountInfoFragment;
    private tomaszkopacz.meetbam.view.AccountPhotosFragment mAccountPhotosFragment;
    private tomaszkopacz.meetbam.view.AccountFriendsFragment mAccountFriendsFragment;
    private static final java.lang.String ACCOUNT_TITLE = "ACCOUNT";
    private static final java.lang.String PHOTOS_TITLE = "PHOTOS";
    private static final java.lang.String FRIENDS_TITLE = "FRIENDS";
    public static final tomaszkopacz.meetbam.view.AccountActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final tomaszkopacz.meetbam.view.MainApp getApp() {
        return null;
    }
    
    public final void setApp(@org.jetbrains.annotations.Nullable()
    tomaszkopacz.meetbam.view.MainApp p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setUpViewPager(android.support.v4.view.ViewPager viewPager) {
    }
    
    public AccountActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ltomaszkopacz/meetbam/view/AccountActivity$Companion;", "", "()V", "ACCOUNT_TITLE", "", "FRIENDS_TITLE", "PHOTOS_TITLE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}