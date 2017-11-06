package luk.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import luk.legacy.Service;

@Decorator
public class ServiceDecorator implements Service {

    @Inject
    @Delegate
    private Service service;

    @Override
    public String sayHello() {
        return "nice hello, but was: " + service.sayHello();
    }
}
