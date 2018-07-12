package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Ltomaszkopacz/meetbam/presenter/StatsGlobalFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "fragment", "Ltomaszkopacz/meetbam/view/StatsGlobalFragment;", "(Ltomaszkopacz/meetbam/view/StatsGlobalFragment;)V", "adapter", "Ltomaszkopacz/meetbam/service/UserAdapter;", "results", "", "Ltomaszkopacz/meetbam/entity/UserResult;", "webService", "Ltomaszkopacz/meetbam/interactor/WebService;", "getWebService", "()Ltomaszkopacz/meetbam/interactor/WebService;", "setWebService", "(Ltomaszkopacz/meetbam/interactor/WebService;)V", "downloadResults", "", "itemCount", "", "onItemBoundAtPosition", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "position", "onItemClick", "view", "Landroid/view/View;", "onLongItemClick", "app_debug"})
public final class StatsGlobalFragmentPresenter implements tomaszkopacz.meetbam.presenter.RecyclerViewPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.WebService webService;
    private final tomaszkopacz.meetbam.service.UserAdapter adapter = null;
    private java.util.List<tomaszkopacz.meetbam.entity.UserResult> results;
    private final tomaszkopacz.meetbam.view.StatsGlobalFragment fragment = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.WebService getWebService() {
        return null;
    }
    
    public final void setWebService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.WebService p0) {
    }
    
    public final void downloadResults() {
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
    
    public StatsGlobalFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.StatsGlobalFragment fragment) {
        super();
    }
}