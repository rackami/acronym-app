package me.kamili.rachid.acronymsapp.view.acronyms;

import java.util.List;

import me.kamili.rachid.acronymsapp.module.LongForm;
import me.kamili.rachid.acronymsapp.view.base.BaseView;

public interface MainView extends BaseView {
    void onClear();

    void onAcronymsLoaded(List<LongForm> acronyms);
}
