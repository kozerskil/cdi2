package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import luk.model.Payload;

@ApplicationScoped
public class Snippet6 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .disableDiscovery()
            .addBeanClasses(Snippet6.class)
            .initialize();

        BeanManager bm = CDI.current().getBeanManager();
        bm.getEvent().fireAsync(new Payload("r2d2"));

        container.close();
    }

    public void doSomething(@ObservesAsync Payload payload) {
        System.out.println(payload.sayHello());
    }
}
