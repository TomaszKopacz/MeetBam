package tomaszkopacz.meetbam.di

import dagger.Module
import dagger.Provides
import tomaszkopacz.meetbam.interactor.ImageFilesService
import javax.inject.Singleton

@Module
class ImageFilesModule {

    @Provides
    @Singleton
    fun provideImageFilesService(): ImageFilesService {
        return ImageFilesService()
    }
}