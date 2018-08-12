package tomaszkopacz.meetbam.di

import dagger.Component
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.presenter.*
import javax.inject.Singleton

@Singleton
@Component(modules = [WebServiceModule::class, FirebaseModule::class])
interface AppComponent {

    fun inject(service: AuthService)

    fun inject(presenter: LoginActivityPresenter)

    fun inject(presenter: PersonalisationActivityPresenter)

    fun inject(presenter: MainActivityPresenter)
    fun inject(presenter: MainPostsFragmentPresenter)
    fun inject(presenter: MainPhotoFragmentPresenter)

    fun inject(presenter: AccountPhotosFragmentPresenter)
    fun inject(presenter: AccountFriendsFragmentPresenter)

    fun inject(presenter: StatsGlobalFragmentPresenter)
    fun inject(presenter: StatsLocalFragmentPresenter)
}