package luk.legacy;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class ServiceDecorator implements Service {

    @Inject
    @Delegate
    private Service service;

    @Override
    public String sayHello() {
        return "nice hello";
    }
}
