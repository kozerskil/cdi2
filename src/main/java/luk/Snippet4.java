package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import luk.model.Payload;

@ApplicationScoped
public class Snippet4 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Snippet4 snippet = container.select(Snippet4.class).get();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private Event<Payload> event;

    public void sayHi() {
        System.out.println("Fire from " + Thread.currentThread().getName());
        event.fireAsync(new Payload("r2d2"));
    }

    public void doSomething(@ObservesAsync Payload payload) {
        System.out.println(payload.sayHello());
    }
}
