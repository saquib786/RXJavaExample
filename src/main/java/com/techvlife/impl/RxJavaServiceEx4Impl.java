package com.techvlife.impl;

import com.techvlife.service.RxJavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.schedulers.Schedulers;

@Component
public class RxJavaServiceEx4Impl implements RxJavaService {

    Logger logger = LoggerFactory.getLogger(RxJavaServiceEx1Impl.class);

    @Override
    public void process() {

        logger.info(":::::::::::::::::::::: Start ::  Fourth Example {} ::::::::::::::::::::::::::::::::::::::",Thread.currentThread().getName());

        Observable<String> firstObs = Observable.just("Iron Man","Captain America","Hulk","Ant Man");

        logger.info(":::::::Third Way for observable:::::");
        firstObs.map( val -> {
            logger.info("On Next called for : {} and Thread Name : {}", val,Thread.currentThread().getName());
            return val;
        }).doOnError(e -> {}).subscribeOn(Schedulers.io()).subscribe();

        logger.info(":::::::::::::::::::::::::: End ::  Fourth Example {}:::::::::::::::::::::::::::::::::",Thread.currentThread().getName());


    }
}
