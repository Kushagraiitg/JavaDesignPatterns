package com.example.observer;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class FlowTest{
    public static void main(String[] args){
        List<String> items = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        publisher.subscribe(new MySubscriber<>());
        items.forEach(s->{
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            publisher.submit(s);
        });
        publisher.close();
    }
}