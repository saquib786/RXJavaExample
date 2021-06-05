package com.techvlife.impl;

import com.techvlife.service.RxJavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

@Component
public class RxJavaServiceEx3Impl implements RxJavaService {

    Logger logger = LoggerFactory.getLogger(RxJavaServiceEx1Impl.class);

    @Override
    public void process() {

        logger.info(":::::::::::::::::::::: Start ::  Third Example {} ::::::::::::::::::::::::::::::::::::::",Thread.currentThread().getName());

        Observable<String> firstObs = Observable.just("Iron Man","Captain America","Hulk","Ant Man");

        logger.info(":::::::First Way for observable:::::");
        firstObs.doOnNext( val -> {
            logger.info("On Next called for : {} and Thread Name : {}", val,Thread.currentThread().getName());
        }).doOnError( e -> {
            logger.error("Error occurred : {}", e.getMessage());
        }).subscribe();

        logger.info(":::::::Second Way for observable:::::");
        firstObs.doOnNext( val -> {
            logger.info("On Next called for : {} and Thread Name : {}", val,Thread.currentThread().getName());
        }).doOnError( e -> {
            logger.error("Error occurred : {}", e.getMessage());
        }).subscribeOn(Schedulers.io()).subscribe();

        logger.info(":::::::::::::::::::::::::: End ::  Third Example {}:::::::::::::::::::::::::::::::::",Thread.currentThread().getName());

    }
}
