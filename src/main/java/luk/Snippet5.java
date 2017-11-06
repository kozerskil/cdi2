package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import luk.model.Payload;

@ApplicationScoped
public class Snippet5 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .disableDiscovery()
            .addBeanClasses(Snippet5.class)
            .initialize();

        BeanManager bm = CDI.current().getBeanManager();
        bm.fireEvent(new Payload("r2d2"));

        container.close();
    }

    public void doSomething(@Observes Payload payload) {
        System.out.println(payload.sayHello());
    }
}
