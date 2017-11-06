package luk;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Snippet1 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .disableDiscovery()
            .addBeanClasses(Snippet1.class)
            .initialize();

        Snippet1 snippet = container.select(Snippet1.class).get();
        snippet.sayHi();

        container.close();
    }

    public void sayHi() {
        System.out.println("hi");
    }
}
