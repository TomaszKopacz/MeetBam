package tomaszkopacz.meetbam.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Ltomaszkopacz/meetbam/di/WebServiceComponent;", "", "inject", "", "mAccountFriendsFragmentPresenter", "Ltomaszkopacz/meetbam/presenter/AccountFriendsFragmentPresenter;", "mAccountPhotosFragmentPresenter", "Ltomaszkopacz/meetbam/presenter/AccountPhotosFragmentPresenter;", "mLoginActivityPresenter", "Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter;", "mainActivityPresenter", "Ltomaszkopacz/meetbam/presenter/MainPostsFragmentPresenter;", "mStatsGlobalFragmentPresenter", "Ltomaszkopacz/meetbam/presenter/StatsGlobalFragmentPresenter;", "mStatsLocalFragmentPresenter", "Ltomaszkopacz/meetbam/presenter/StatsLocalFragmentPresenter;", "app_debug"})
@dagger.Component(modules = {tomaszkopacz.meetbam.di.WebServiceModule.class})
@javax.inject.Singleton()
public abstract interface WebServiceComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter mainActivityPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.LoginActivityPresenter mLoginActivityPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.AccountPhotosFragmentPresenter mAccountPhotosFragmentPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.AccountFriendsFragmentPresenter mAccountFriendsFragmentPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter mStatsGlobalFragmentPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter mStatsLocalFragmentPresenter);
}