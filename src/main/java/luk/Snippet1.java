package luk;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Snippet1 {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance()
            .initialize();

        Instance<Snippet1> instance = container.select(Snippet1.class);
        Snippet1 snippet = instance.get();
        snippet.sayHi();
    }

    private void sayHi() {
        System.out.println("hi");
    }
}
