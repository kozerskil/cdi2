package luk;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.InterceptionFactory;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import luk.interceptors.Log;
import luk.legacy.LegacyService;

@Alternative
@Priority(500)
@ApplicationScoped
public class Snippet9 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Snippet9 snippet = container.select(Snippet9.class).get();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private LegacyService service;

    public void sayHi() {
        System.out.println(service.sayHello());
    }

    @Produces
    public LegacyService createService(InterceptionFactory<LegacyService> factory) {
        factory.configure().add(new AnnotationLiteral<Log>() {
        });
        return factory.createInterceptedInstance(new LegacyService());
    }
}
