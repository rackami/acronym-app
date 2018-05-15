package me.kamili.rachid.acronymsapp.view.base;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V extends BaseView> {

    @Inject
    protected V mView;

    protected V getView() {
        return mView;
    }

    protected void dettachView() {
        mView = null;
    }

    protected <T,R> void subscribe(Observable<T> observable, Observer<R> observer,
                                   Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
        observable
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .flatMap(mapper)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
