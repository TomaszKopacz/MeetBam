package tomaszkopacz.meetbam.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Ltomaszkopacz/meetbam/di/AppComponent;", "", "inject", "", "presenter", "Ltomaszkopacz/meetbam/presenter/AccountFriendsFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/AccountPhotosFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/LoginActivityPresenter;", "Ltomaszkopacz/meetbam/presenter/MainActivityPresenter;", "Ltomaszkopacz/meetbam/presenter/MainPostsFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/PersonalisationActivityPresenter;", "Ltomaszkopacz/meetbam/presenter/StatsGlobalFragmentPresenter;", "Ltomaszkopacz/meetbam/presenter/StatsLocalFragmentPresenter;", "app_debug"})
@dagger.Component(modules = {tomaszkopacz.meetbam.di.WebServiceModule.class, tomaszkopacz.meetbam.di.FirebaseModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.LoginActivityPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.PersonalisationActivityPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.MainActivityPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.AccountPhotosFragmentPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.AccountFriendsFragmentPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter presenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter presenter);
}