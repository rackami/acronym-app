package me.kamili.rachid.acronymsapp.injection.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import me.kamili.rachid.acronymsapp.injection.module.ContextModule;
import me.kamili.rachid.acronymsapp.injection.module.NetworkModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ContextModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
