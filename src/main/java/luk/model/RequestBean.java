package luk.model;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestBean {

    public String sayHello() {
        return "hello from bean " + hashCode();
    }
}
