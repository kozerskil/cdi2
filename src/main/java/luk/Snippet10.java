package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.Unmanaged;

import luk.legacy.LegacyService;
import luk.model.Payload;

@ApplicationScoped
public class Snippet10 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .disableDiscovery()
            .addBeanClasses(Snippet10.class)
//            .addBeanClasses(LegacyService.class)
            .initialize();

        Snippet10 snippet = container.select(Snippet10.class).get();
        snippet.sayHi();

        container.close();
    }

    public void sayHi() {
        LegacyService service = create();
        System.out.println(service.sayHello());
    }

    public LegacyService create() {
        Unmanaged<LegacyService> unmanaged = new Unmanaged(LegacyService.class);
        Unmanaged.UnmanagedInstance<LegacyService> inst = unmanaged.newInstance();
        return inst.produce().inject().get();
    }

    @Produces
    public Payload createPayload() {
        return new Payload("c3p0");
    }
}
