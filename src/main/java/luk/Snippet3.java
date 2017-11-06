package luk;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.RequestContextController;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import luk.model.RequestBean;

@ApplicationScoped
public class Snippet3 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Snippet3 snippet = container.select(Snippet3.class).get();
        snippet.sayHi();
        snippet.sayHi();

        container.close();
    }

    @Inject
    private RequestBean bean;
    @Inject
    private RequestContextController requestContextController;

    public void sayHi() {
        requestContextController.activate();

        System.out.println(bean.toString());

        requestContextController.deactivate();
    }
}
