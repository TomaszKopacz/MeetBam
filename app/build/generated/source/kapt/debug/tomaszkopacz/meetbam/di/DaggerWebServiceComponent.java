// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package tomaszkopacz.meetbam.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import tomaszkopacz.meetbam.interactor.WebService;
import tomaszkopacz.meetbam.presenter.AccountFriendsFragmentPresenter;
import tomaszkopacz.meetbam.presenter.AccountFriendsFragmentPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.AccountPhotosFragmentPresenter;
import tomaszkopacz.meetbam.presenter.AccountPhotosFragmentPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.LoginActivityPresenter;
import tomaszkopacz.meetbam.presenter.LoginActivityPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter;
import tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter;
import tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter;
import tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter_MembersInjector;

public final class DaggerWebServiceComponent implements WebServiceComponent {
  private Provider<OkHttpClient> provideOkHttpClient$app_debugProvider;

  private Provider<Retrofit> provideRetrofit$app_debugProvider;

  private Provider<WebService> provideWebService$app_debugProvider;

  private DaggerWebServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static WebServiceComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideOkHttpClient$app_debugProvider =
        DoubleCheck.provider(
            WebServiceModule_ProvideOkHttpClient$app_debugFactory.create(builder.webServiceModule));
    this.provideRetrofit$app_debugProvider =
        DoubleCheck.provider(
            WebServiceModule_ProvideRetrofit$app_debugFactory.create(
                builder.webServiceModule, provideOkHttpClient$app_debugProvider));
    this.provideWebService$app_debugProvider =
        DoubleCheck.provider(
            WebServiceModule_ProvideWebService$app_debugFactory.create(
                builder.webServiceModule, provideRetrofit$app_debugProvider));
  }

  @Override
  public void inject(MainPostsFragmentPresenter mainActivityPresenter) {
    injectMainPostsFragmentPresenter(mainActivityPresenter);
  }

  @Override
  public void inject(LoginActivityPresenter mLoginActivityPresenter) {
    injectLoginActivityPresenter(mLoginActivityPresenter);
  }

  @Override
  public void inject(AccountPhotosFragmentPresenter mAccountPhotosFragmentPresenter) {
    injectAccountPhotosFragmentPresenter(mAccountPhotosFragmentPresenter);
  }

  @Override
  public void inject(AccountFriendsFragmentPresenter mAccountFriendsFragmentPresenter) {
    injectAccountFriendsFragmentPresenter(mAccountFriendsFragmentPresenter);
  }

  @Override
  public void inject(StatsGlobalFragmentPresenter mStatsGlobalFragmentPresenter) {
    injectStatsGlobalFragmentPresenter(mStatsGlobalFragmentPresenter);
  }

  @Override
  public void inject(StatsLocalFragmentPresenter mStatsLocalFragmentPresenter) {
    injectStatsLocalFragmentPresenter(mStatsLocalFragmentPresenter);
  }

  private MainPostsFragmentPresenter injectMainPostsFragmentPresenter(
      MainPostsFragmentPresenter instance) {
    MainPostsFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebService$app_debugProvider.get());
    return instance;
  }

  private LoginActivityPresenter injectLoginActivityPresenter(LoginActivityPresenter instance) {
    LoginActivityPresenter_MembersInjector.injectWebService(
        instance, provideWebService$app_debugProvider.get());
    return instance;
  }

  private AccountPhotosFragmentPresenter injectAccountPhotosFragmentPresenter(
      AccountPhotosFragmentPresenter instance) {
    AccountPhotosFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebService$app_debugProvider.get());
    return instance;
  }

  private AccountFriendsFragmentPresenter injectAccountFriendsFragmentPresenter(
      AccountFriendsFragmentPresenter instance) {
    AccountFriendsFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebService$app_debugProvider.get());
    return instance;
  }

  private StatsGlobalFragmentPresenter injectStatsGlobalFragmentPresenter(
      StatsGlobalFragmentPresenter instance) {
    StatsGlobalFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebService$app_debugProvider.get());
    return instance;
  }

  private StatsLocalFragmentPresenter injectStatsLocalFragmentPresenter(
      StatsLocalFragmentPresenter instance) {
    StatsLocalFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebService$app_debugProvider.get());
    return instance;
  }

  public static final class Builder {
    private WebServiceModule webServiceModule;

    private Builder() {}

    public WebServiceComponent build() {
      if (webServiceModule == null) {
        this.webServiceModule = new WebServiceModule();
      }
      return new DaggerWebServiceComponent(this);
    }

    public Builder webServiceModule(WebServiceModule webServiceModule) {
      this.webServiceModule = Preconditions.checkNotNull(webServiceModule);
      return this;
    }
  }
}
