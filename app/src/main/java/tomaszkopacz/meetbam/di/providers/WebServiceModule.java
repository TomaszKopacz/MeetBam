package tomaszkopacz.meetbam.di.providers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tomaszkopacz.meetbam.web_service.WebService;

/**
 * Created by tomas on 19.02.2018.
 * Module providing web service.
 */

@Module
public class WebServiceModule {

    private static final String BASE_URL = "http://meetbam.cba.pl";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    WebService provideWebService(Retrofit retrofit){
        return retrofit.create(WebService.class);
    }
}
