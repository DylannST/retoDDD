package domain.generalvalues;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<String> {

    private String value;

    public Nombre(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
