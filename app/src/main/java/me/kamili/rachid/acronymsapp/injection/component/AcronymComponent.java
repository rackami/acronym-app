package me.kamili.rachid.acronymsapp.injection.component;

import dagger.Component;
import me.kamili.rachid.acronymsapp.view.acronyms.MainActivity;
import me.kamili.rachid.acronymsapp.injection.module.AcronymsModule;
import me.kamili.rachid.acronymsapp.injection.scope.PerActivity;

@PerActivity
@Component(modules = AcronymsModule.class, dependencies = ApplicationComponent.class)
public interface AcronymComponent {
    void inject(MainActivity activity);
}
