// Generated by Dagger (https://google.github.io/dagger).
package tomaszkopacz.meetbam.di;

import com.google.firebase.auth.FirebaseAuth;
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
import tomaszkopacz.meetbam.presenter.MainActivityPresenter;
import tomaszkopacz.meetbam.presenter.MainActivityPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter;
import tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.PersonalisationActivityPresenter;
import tomaszkopacz.meetbam.presenter.PersonalisationActivityPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter;
import tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter_MembersInjector;
import tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter;
import tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter_MembersInjector;

public final class DaggerAppComponent implements AppComponent {
  private Provider<OkHttpClient> provideOkHttpClient$app_debugProvider;

  private Provider<Retrofit> provideRetrofit$app_debugProvider;

  private Provider<WebService> provideWebServiceProvider;

  private Provider<FirebaseAuth> provideFirebasAuthProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
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
    this.provideWebServiceProvider =
        DoubleCheck.provider(
            WebServiceModule_ProvideWebServiceFactory.create(
                builder.webServiceModule, provideRetrofit$app_debugProvider));
    this.provideFirebasAuthProvider =
        DoubleCheck.provider(
            FirebaseModule_ProvideFirebasAuthFactory.create(builder.firebaseModule));
  }

  @Override
  public void inject(LoginActivityPresenter presenter) {
    injectLoginActivityPresenter(presenter);
  }

  @Override
  public void inject(PersonalisationActivityPresenter presenter) {
    injectPersonalisationActivityPresenter(presenter);
  }

  @Override
  public void inject(MainActivityPresenter presenter) {
    injectMainActivityPresenter(presenter);
  }

  @Override
  public void inject(MainPostsFragmentPresenter presenter) {
    injectMainPostsFragmentPresenter(presenter);
  }

  @Override
  public void inject(AccountPhotosFragmentPresenter presenter) {
    injectAccountPhotosFragmentPresenter(presenter);
  }

  @Override
  public void inject(AccountFriendsFragmentPresenter presenter) {
    injectAccountFriendsFragmentPresenter(presenter);
  }

  @Override
  public void inject(StatsGlobalFragmentPresenter presenter) {
    injectStatsGlobalFragmentPresenter(presenter);
  }

  @Override
  public void inject(StatsLocalFragmentPresenter presenter) {
    injectStatsLocalFragmentPresenter(presenter);
  }

  private LoginActivityPresenter injectLoginActivityPresenter(LoginActivityPresenter instance) {
    LoginActivityPresenter_MembersInjector.injectWebService(
        instance, provideWebServiceProvider.get());
    LoginActivityPresenter_MembersInjector.injectAuth(instance, provideFirebasAuthProvider.get());
    return instance;
  }

  private PersonalisationActivityPresenter injectPersonalisationActivityPresenter(
      PersonalisationActivityPresenter instance) {
    PersonalisationActivityPresenter_MembersInjector.injectAuth(
        instance, provideFirebasAuthProvider.get());
    return instance;
  }

  private MainActivityPresenter injectMainActivityPresenter(MainActivityPresenter instance) {
    MainActivityPresenter_MembersInjector.injectAuth(instance, provideFirebasAuthProvider.get());
    return instance;
  }

  private MainPostsFragmentPresenter injectMainPostsFragmentPresenter(
      MainPostsFragmentPresenter instance) {
    MainPostsFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebServiceProvider.get());
    MainPostsFragmentPresenter_MembersInjector.injectAuth(
        instance, provideFirebasAuthProvider.get());
    return instance;
  }

  private AccountPhotosFragmentPresenter injectAccountPhotosFragmentPresenter(
      AccountPhotosFragmentPresenter instance) {
    AccountPhotosFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebServiceProvider.get());
    return instance;
  }

  private AccountFriendsFragmentPresenter injectAccountFriendsFragmentPresenter(
      AccountFriendsFragmentPresenter instance) {
    AccountFriendsFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebServiceProvider.get());
    return instance;
  }

  private StatsGlobalFragmentPresenter injectStatsGlobalFragmentPresenter(
      StatsGlobalFragmentPresenter instance) {
    StatsGlobalFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebServiceProvider.get());
    return instance;
  }

  private StatsLocalFragmentPresenter injectStatsLocalFragmentPresenter(
      StatsLocalFragmentPresenter instance) {
    StatsLocalFragmentPresenter_MembersInjector.injectWebService(
        instance, provideWebServiceProvider.get());
    return instance;
  }

  public static final class Builder {
    private WebServiceModule webServiceModule;

    private FirebaseModule firebaseModule;

    private Builder() {}

    public AppComponent build() {
      if (webServiceModule == null) {
        this.webServiceModule = new WebServiceModule();
      }
      if (firebaseModule == null) {
        this.firebaseModule = new FirebaseModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder webServiceModule(WebServiceModule webServiceModule) {
      this.webServiceModule = Preconditions.checkNotNull(webServiceModule);
      return this;
    }

    public Builder firebaseModule(FirebaseModule firebaseModule) {
      this.firebaseModule = Preconditions.checkNotNull(firebaseModule);
      return this;
    }
  }
}
