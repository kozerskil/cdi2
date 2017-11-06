package luk.model;

public class Payload {

    private String name;

    public Payload(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "hi from " + name + "on " + Thread.currentThread().getName();
    }
}
