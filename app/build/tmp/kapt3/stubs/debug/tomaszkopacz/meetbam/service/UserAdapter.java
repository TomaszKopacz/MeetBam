package tomaszkopacz.meetbam.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Ltomaszkopacz/meetbam/service/UserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Ltomaszkopacz/meetbam/service/UserAdapter$UserViewHolder;", "presenter", "Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "(Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "UserViewHolder", "app_debug"})
public final class UserAdapter extends android.support.v7.widget.RecyclerView.Adapter<tomaszkopacz.meetbam.service.UserAdapter.UserViewHolder> {
    private final tomaszkopacz.meetbam.presenter.RecyclerViewPresenter presenter = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public tomaszkopacz.meetbam.service.UserAdapter.UserViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.service.UserAdapter.UserViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public UserAdapter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.RecyclerViewPresenter presenter) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\b\u00a8\u0006\u0013"}, d2 = {"Ltomaszkopacz/meetbam/service/UserAdapter$UserViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "result", "Landroid/widget/TextView;", "getResult", "()Landroid/widget/TextView;", "result$delegate", "Lkotlin/properties/ReadOnlyProperty;", "userImage", "Landroid/widget/ImageView;", "getUserImage", "()Landroid/widget/ImageView;", "userImage$delegate", "username", "getUsername", "username$delegate", "app_debug"})
    public static final class UserViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.properties.ReadOnlyProperty username$delegate = null;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.properties.ReadOnlyProperty userImage$delegate = null;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.properties.ReadOnlyProperty result$delegate = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getUsername() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getUserImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getResult() {
            return null;
        }
        
        public UserViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}