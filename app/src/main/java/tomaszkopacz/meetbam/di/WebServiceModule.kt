package tomaszkopacz.meetbam.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tomaszkopacz.meetbam.interactor.WebService
import javax.inject.Singleton

@Module
class WebServiceModule {

    companion object {
        private val BASE_URL = "http://meetbam.cba.pl"
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }
}
