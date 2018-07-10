package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainPostsFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "fragment", "Ltomaszkopacz/meetbam/view/MainPostsFragment;", "(Ltomaszkopacz/meetbam/view/MainPostsFragment;)V", "BASE_URL", "", "adapter", "Ltomaszkopacz/meetbam/service/PostAdapter;", "mLoginService", "Ltomaszkopacz/meetbam/service/LoginService;", "posts", "", "Ltomaszkopacz/meetbam/entity/Post;", "webService", "Ltomaszkopacz/meetbam/interactor/WebService;", "getWebService", "()Ltomaszkopacz/meetbam/interactor/WebService;", "setWebService", "(Ltomaszkopacz/meetbam/interactor/WebService;)V", "downloadPosts", "", "itemCount", "", "onItemBoundAtPosition", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "position", "onItemClick", "view", "Landroid/view/View;", "refresh", "app_debug"})
public final class MainPostsFragmentPresenter implements tomaszkopacz.meetbam.presenter.RecyclerViewPresenter {
    private final java.lang.String BASE_URL = "http://meetbam.cba.pl/";
    private tomaszkopacz.meetbam.service.LoginService mLoginService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.WebService webService;
    private tomaszkopacz.meetbam.service.PostAdapter adapter;
    private java.util.List<tomaszkopacz.meetbam.entity.Post> posts;
    private final tomaszkopacz.meetbam.view.MainPostsFragment fragment = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.WebService getWebService() {
        return null;
    }
    
    public final void setWebService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.WebService p0) {
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