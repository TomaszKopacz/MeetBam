// Generated by Dagger (https://google.github.io/dagger).
package tomaszkopacz.meetbam.presenter;

import dagger.MembersInjector;
import javax.inject.Provider;
import tomaszkopacz.meetbam.interactor.AuthService;

public final class MainActivityPresenter_MembersInjector
    implements MembersInjector<MainActivityPresenter> {
  private final Provider<AuthService> authServiceProvider;

  public MainActivityPresenter_MembersInjector(Provider<AuthService> authServiceProvider) {
    this.authServiceProvider = authServiceProvider;
  }

  public static MembersInjector<MainActivityPresenter> create(
      Provider<AuthService> authServiceProvider) {
    return new MainActivityPresenter_MembersInjector(authServiceProvider);
  }

  @Override
  public void injectMembers(MainActivityPresenter instance) {
    injectAuthService(instance, authServiceProvider.get());
  }

  public static void injectAuthService(MainActivityPresenter instance, AuthService authService) {
    instance.authService = authService;
  }
}
