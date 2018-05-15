package me.kamili.rachid.acronymsapp.application;

import android.app.Application;

import me.kamili.rachid.acronymsapp.injection.component.ApplicationComponent;
import me.kamili.rachid.acronymsapp.injection.component.DaggerApplicationComponent;
import me.kamili.rachid.acronymsapp.injection.module.ContextModule;
import me.kamili.rachid.acronymsapp.injection.module.NetworkModule;

public class MyApplication extends Application {

    private static final String BASE_URL = "http://www.nactem.ac.uk";

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
