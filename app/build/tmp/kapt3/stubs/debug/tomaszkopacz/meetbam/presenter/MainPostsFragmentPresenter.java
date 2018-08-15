package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010&\u001a\u00020\'J\b\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020)H\u0016J\u0010\u0010.\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0016J\u0006\u00102\u001a\u00020\'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00063"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainPostsFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "fragment", "Ltomaszkopacz/meetbam/view/MainPostsFragment;", "(Ltomaszkopacz/meetbam/view/MainPostsFragment;)V", "adapter", "Ltomaszkopacz/meetbam/view/PostAdapter;", "app", "Ltomaszkopacz/meetbam/view/MainApp;", "getApp", "()Ltomaszkopacz/meetbam/view/MainApp;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "database", "Ltomaszkopacz/meetbam/interactor/DatabaseService;", "getDatabase", "()Ltomaszkopacz/meetbam/interactor/DatabaseService;", "setDatabase", "(Ltomaszkopacz/meetbam/interactor/DatabaseService;)V", "posts", "", "Ltomaszkopacz/meetbam/entity/Post;", "storage", "Ltomaszkopacz/meetbam/interactor/StorageService;", "getStorage", "()Ltomaszkopacz/meetbam/interactor/StorageService;", "setStorage", "(Ltomaszkopacz/meetbam/interactor/StorageService;)V", "webService", "Ltomaszkopacz/meetbam/interactor/WebService;", "getWebService", "()Ltomaszkopacz/meetbam/interactor/WebService;", "setWebService", "(Ltomaszkopacz/meetbam/interactor/WebService;)V", "downloadPosts", "", "itemCount", "", "onItemBoundAtPosition", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "position", "onItemClick", "view", "Landroid/view/View;", "onLongItemClick", "refresh", "app_debug"})
public final class MainPostsFragmentPresenter implements tomaszkopacz.meetbam.presenter.RecyclerViewPresenter {
    @org.jetbrains.annotations.NotNull()
    private final tomaszkopacz.meetbam.view.MainApp app = null;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.WebService webService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.DatabaseService database;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.StorageService storage;
    private tomaszkopacz.meetbam.view.PostAdapter adapter;
    private java.util.List<tomaszkopacz.meetbam.entity.Post> posts;
    private final tomaszkopacz.meetbam.view.MainPostsFragment fragment = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.view.MainApp getApp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.WebService getWebService() {
        return null;
    }
    
    public final void setWebService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.WebService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.DatabaseService getDatabase() {
        return null;
    }
    
    public final void setDatabase(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.DatabaseService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.StorageService getStorage() {
        return null;
    }
    
    public final void setStorage(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.StorageService p0) {
    }
    
    public final void downloadPosts() {
    }
    
    @java.lang.Override()
    public void onItemBoundAtPosition(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onLongItemClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public int itemCount() {
        return 0;
    }
    
    public final void refresh() {
    }
    
    public MainPostsFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainPostsFragment fragment) {
        super();
    }
}