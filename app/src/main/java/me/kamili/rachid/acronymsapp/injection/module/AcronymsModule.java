package me.kamili.rachid.acronymsapp.injection.module;

import dagger.Module;
import dagger.Provides;
import me.kamili.rachid.acronymsapp.api.ApiService;
import me.kamili.rachid.acronymsapp.injection.scope.PerActivity;
import me.kamili.rachid.acronymsapp.view.acronyms.MainView;
import retrofit2.Retrofit;

@Module
public class AcronymsModule {

    private MainView mView;

    public AcronymsModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }

    @PerActivity
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
