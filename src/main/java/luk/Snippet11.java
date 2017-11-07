package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.literal.InjectLiteral;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTargetFactory;
import javax.inject.Inject;

import luk.legacy.LegacyService;
import luk.model.Payload;

@ApplicationScoped
public class Snippet11 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .disableDiscovery()
            .addBeanClasses(Snippet11.class)
//            .addBeanClasses(LegacyService.class)
            .initialize();

        Snippet11 snippet = container.select(Snippet11.class).get();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private BeanManager bm;

    public void sayHi() {
        LegacyService service = create();
        System.out.println(service.sayHello());
    }

    public LegacyService create() {
        AnnotatedType<LegacyService> atmc = bm.createAnnotatedType(LegacyService.class);
        InjectionTargetFactory<LegacyService> itf = bm.getInjectionTargetFactory(atmc);
        itf.configure().filterMethods(m -> m.getJavaMember()
            .getName().equals("setPayload"))
            .findFirst()
            .ifPresent(m -> m.add(InjectLiteral.INSTANCE));
        LegacyService service = new LegacyService();
        itf.createInjectionTarget(null)
            .inject(service, bm.createCreationalContext(null));
        return service;
    }

    @Produces
    public Payload createPayload() {
        return new Payload("c3p0");
    }
}
