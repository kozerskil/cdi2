package luk.legacy;

import luk.model.Payload;

public class LegacyService {

    private Payload payload;

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String sayHello() {
        return "hi from " + payload;
    }
}
