package luk;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import luk.interceptors.Log;
import luk.interceptors.Service;

public class Snippet7 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Snippet7 snippet = container.select(Snippet7.class).get();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private Service service;

    @Log
    public void sayHi() {
        System.out.println(service.sayHello());
    }
}
