package tomaszkopacz.meetbam.di

import dagger.Component
import tomaszkopacz.meetbam.presenter.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    WebServiceModule::class,
    FirebaseModule::class,
    ImageFilesModule::class])
interface AppComponent {

    fun inject(presenter: LoginActivityPresenter)

    fun inject(presenter: PersonalisationActivityPresenter)
    fun inject(presenter: PersonDataFragmentPresenter)
    fun inject(presenter: PersonPhotoFragmentPresenter)

    fun inject(presenter: MainActivityPresenter)
    fun inject(presenter: MainPostsFragmentPresenter)
    fun inject(presenter: MainPhotoFragmentPresenter)

    fun inject(presenter: AccountPhotosFragmentPresenter)
    fun inject(presenter: AccountFriendsFragmentPresenter)

    fun inject(presenter: StatsGlobalFragmentPresenter)
    fun inject(presenter: StatsLocalFragmentPresenter)
}