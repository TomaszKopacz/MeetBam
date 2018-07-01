package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "", "itemCount", "", "onItemBoundAtPosition", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "position", "onItemClick", "view", "Landroid/view/View;", "app_debug"})
public abstract interface RecyclerViewPresenter {
    
    public abstract void onItemBoundAtPosition(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder holder, int position);
    
    public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract int itemCount();
}