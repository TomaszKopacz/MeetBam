package tomaszkopacz.meetbam.di

import dagger.Component
import tomaszkopacz.meetbam.presenter.*
import javax.inject.Singleton

@Singleton
@Component(modules = [(WebServiceModule::class)])
interface WebServiceComponent {

    fun inject(mainActivityPresenter: MainPostsFragmentPresenter)
    fun inject(mLoginActivityPresenter: LoginActivityPresenter)

    fun inject(mAccountPhotosFragmentPresenter: AccountPhotosFragmentPresenter)
    fun inject(mAccountFriendsFragmentPresenter: AccountFriendsFragmentPresenter)

    fun inject(mStatsGlobalFragmentPresenter: StatsGlobalFragmentPresenter)
    fun inject(mStatsLocalFragmentPresenter: StatsLocalFragmentPresenter)
}
