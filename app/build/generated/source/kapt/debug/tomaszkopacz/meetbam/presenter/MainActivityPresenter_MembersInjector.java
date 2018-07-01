// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package tomaszkopacz.meetbam.presenter;

import dagger.MembersInjector;
import javax.inject.Provider;
import tomaszkopacz.meetbam.interactor.WebService;

public final class MainActivityPresenter_MembersInjector
    implements MembersInjector<MainActivityPresenter> {
  private final Provider<WebService> webServiceProvider;

  public MainActivityPresenter_MembersInjector(Provider<WebService> webServiceProvider) {
    this.webServiceProvider = webServiceProvider;
  }

  public static MembersInjector<MainActivityPresenter> create(
      Provider<WebService> webServiceProvider) {
    return new MainActivityPresenter_MembersInjector(webServiceProvider);
  }

  @Override
  public void injectMembers(MainActivityPresenter instance) {
    injectWebService(instance, webServiceProvider.get());
  }

  public static void injectWebService(MainActivityPresenter instance, WebService webService) {
    instance.webService = webService;
  }
}