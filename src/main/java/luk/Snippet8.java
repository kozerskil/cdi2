package luk;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.InterceptionFactory;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import luk.interceptors.Log;
import luk.interceptors.Service;
import luk.interceptors.SimpleService;

public class Snippet8 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Snippet8 snippet = container.select(Snippet8.class).get();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private Service service;

    public void sayHi() {
        System.out.println(service.sayHello());
    }

    @Produces
    public Service createService(InterceptionFactory<Service> factory) {
        factory.configure().add(new AnnotationLiteral<Log>() {
        });
        return factory.createInterceptedInstance(new SimpleService());
    }
}
