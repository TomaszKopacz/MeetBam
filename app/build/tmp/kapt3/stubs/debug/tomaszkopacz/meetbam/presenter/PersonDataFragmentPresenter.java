package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Ltomaszkopacz/meetbam/presenter/PersonDataFragmentPresenter;", "", "fragment", "Ltomaszkopacz/meetbam/view/PersonDataFragment;", "(Ltomaszkopacz/meetbam/view/PersonDataFragment;)V", "auth", "Ltomaszkopacz/meetbam/interactor/AuthService;", "getAuth", "()Ltomaszkopacz/meetbam/interactor/AuthService;", "setAuth", "(Ltomaszkopacz/meetbam/interactor/AuthService;)V", "progressDialog", "Ltomaszkopacz/meetbam/dialogs/ProgressDialog;", "confirmUser", "", "userFullName", "", "skip", "app_debug"})
public final class PersonDataFragmentPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.AuthService auth;
    private final tomaszkopacz.meetbam.dialogs.ProgressDialog progressDialog = null;
    private final tomaszkopacz.meetbam.view.PersonDataFragment fragment = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.AuthService getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.AuthService p0) {
    }
    
    public final void skip() {
    }
    
    public final void confirmUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userFullName) {
    }
    
    public PersonDataFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.PersonDataFragment fragment) {
        super();
    }
}