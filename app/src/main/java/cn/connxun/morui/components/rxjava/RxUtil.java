package cn.connxun.morui.components.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wushange on 2017/9/14.
 */

public class RxUtil {

    public static Observable<Object> runOnIoThreadTask() {
        return Observable.create(e -> e.onNext("")).subscribeOn(Schedulers.io()).onErrorResumeNext(new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {
                return Observable.just(throwable);
            }
        });
    }
}