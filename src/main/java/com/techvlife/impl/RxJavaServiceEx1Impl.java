package com.techvlife.impl;

import com.techvlife.service.RxJavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;


@Component
public class RxJavaServiceEx1Impl implements RxJavaService {

    Logger logger = LoggerFactory.getLogger(RxJavaServiceEx1Impl.class);

    @Override
    public void process() {
        logger.info(":::::::::::::::::::::: Start ::  First Example ::::::::::::::::::::::::::::::::::::::");
        // Ways to create a Observable
        // Mainly 3 : create(),just() and from()
        //First Way
        Observable<String> firstObservable = Observable.just("Iron Man","Captain America","Hulk", "Ant Man");

        //Second way
        List<String> avengerList = new ArrayList<>();
        avengerList.add("Iron Man 2");avengerList.add("Captain America 2");avengerList.add("Hulk 2");avengerList.add("Ant Man 2");
        Observable<String> secondObservable = Observable.from(avengerList);

        //Now lets create a Subscriber

        Subscriber<String> subscriber = new Subscriber<String>() {
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
        };

        Subscriber<String> subscriber2 = new Subscriber<String>() {
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
        };

        //Now lets subscribe to firstObservable and check in log the order in which they are printed

        logger.info(":::::::Using UsingFirst Observable:::::");
        firstObservable.subscribe(subscriber);

        logger.info(":::::::Using Second Observable:::::");
        secondObservable.subscribe(subscriber2);

        logger.info(":::::::::::::::::::::::::: End ::  First Example :::::::::::::::::::::::::::::::::");
    }
}
