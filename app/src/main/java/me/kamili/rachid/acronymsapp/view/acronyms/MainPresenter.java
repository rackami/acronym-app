package me.kamili.rachid.acronymsapp.view.acronyms;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.kamili.rachid.acronymsapp.api.ApiService;
import me.kamili.rachid.acronymsapp.module.AcromineResponse;
import me.kamili.rachid.acronymsapp.module.LongForm;
import me.kamili.rachid.acronymsapp.view.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> implements Observer<List<LongForm>> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private Observable<List<AcromineResponse>> mObservable;

    @Inject
    protected ApiService mApiService;

    @Inject
    public MainPresenter() {
    }

    //Get acronyms from api
    public void getAcronyms(String query) {

        getView().onClear();

        if (query.trim().length() < 2) {
            getView().onShowSnackbar("Not enough...");
            return;
        }

        getView().onShowDialog("Loading....");

        //Cancel the previous call if exists
        if (mObservable != null) {
            mObservable.doOnDispose(() -> {
            });
            mObservable = null;
        }

        //Create the request
        mObservable = mApiService.getAcronyms(query.trim());

        //Subscribe and map the results to a list of longforms
        subscribe(mObservable, this,
                response -> Observable.fromIterable(response.get(0).getLfs())
                        .toList().toObservable()
        );
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<LongForm> longForms) {
        getView().onHideDialog();
        if (longForms.size() > 0) {
            getView().onAcronymsLoaded(longForms);
        } else {
            getView().onShowSnackbar("No results for this search");
        }

    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        Log.d(TAG, "onError: " + e.getMessage());
        getView().onShowSnackbar("Error loading " + e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
