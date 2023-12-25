package com.example.observer;
import java.util.concurrent.Flow;

public class MySubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription){
        this.subscription = subscription;
        this.subscription.request(1l);
    }

    @Override
    public void onNext(T item){
        System.out.println(item);
        subscription.request(1);
    }

    @Override
    public void onComplete(){
        System.out.println("Done");
    }

    @Override
    public void onError(Throwable t){
        t.printStackTrace();
    }
    
}
