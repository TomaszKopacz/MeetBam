package tomaszkopacz.meetbam.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J*\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Ltomaszkopacz/meetbam/service/PostAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Ltomaszkopacz/meetbam/service/PostAdapter$PostViewHolder;", "presenter", "Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "(Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setContent", "context", "Landroid/content/Context;", "post", "Ltomaszkopacz/meetbam/entity/Post;", "photoUrl", "", "PostViewHolder", "app_debug"})
public final class PostAdapter extends android.support.v7.widget.RecyclerView.Adapter<tomaszkopacz.meetbam.service.PostAdapter.PostViewHolder> {
    private final tomaszkopacz.meetbam.presenter.RecyclerViewPresenter presenter = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public tomaszkopacz.meetbam.service.PostAdapter.PostViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.service.PostAdapter.PostViewHolder holder, int position) {
    }
    
    public final void setContent(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.service.PostAdapter.PostViewHolder holder, @org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.entity.Post post, @org.jetbrains.annotations.NotNull()
    java.lang.String photoUrl) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public PostAdapter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.RecyclerViewPresenter presenter) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Ltomaszkopacz/meetbam/service/PostAdapter$PostViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Ltomaszkopacz/meetbam/service/PostAdapter;Landroid/view/View;)V", "app_debug"})
    public final class PostViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        
        public PostViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}