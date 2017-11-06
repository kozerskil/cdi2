package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import luk.model.RequestBean;

@ApplicationScoped
public class Snippet2 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Snippet2 snippet = container.select(Snippet2.class).get();
        snippet.sayHi();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private RequestBean bean;

    @ActivateRequestContext
    public void sayHi() {
        System.out.println(bean.sayHello());
        System.out.println(bean.sayHello());
    }
}
