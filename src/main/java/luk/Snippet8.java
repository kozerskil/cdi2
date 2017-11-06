package luk;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import luk.legacy.Service;

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
//
//    @Produces
//    public Service createService(InterceptionFactory<Service> factory) {
//        factory.configure().add(new AnnotationLiteral<Log>() {
//        });
//        return factory.createInterceptedInstance(new SimpleService());
//    }
}
