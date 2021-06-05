package com.techvlife.impl;

import com.techvlife.service.RxJavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;


@Component
public class RxJavaServiceEx2Impl implements RxJavaService {

    Logger logger = LoggerFactory.getLogger(RxJavaServiceEx1Impl.class);

    @Override
    public void process() {

        logger.info(":::::::::::::::::::::: Start ::  Second Example ::::::::::::::::::::::::::::::::::::::");

        Observable<String> firstObs = Observable.just("Iron Man","Captain America","Hulk","Ant Man");

        logger.info(":::::::First Way for observable:::::");
        firstObs.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                logger.info("On Completed Called");
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("Error occurred : {}", throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                logger.info("On Next called for : {}", s);
            }
        });

        logger.info(":::::::Second Way for observable:::::");
        firstObs.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                logger.info("On Completed Called");
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("Error occurred : {}", throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                logger.info("On Next called for : {}", s);
            }
        });

        logger.info(":::::::::::::::::::::::::: End ::  Second Example :::::::::::::::::::::::::::::::::");
    }
}
