package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import luk.legacy.LegacyService;

@ApplicationScoped
public class Snippet10 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .disableDiscovery()
            .addBeanClasses(Snippet10.class)
            .addBeanClasses(LegacyService.class)
            .initialize();

        Snippet10 snippet = container.select(Snippet10.class).get();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private LegacyService service;

    public void sayHi() {
        System.out.println(service.sayHello());
    }

    public LegacyService creeate() {
        return new LegacyService();
    }
}
