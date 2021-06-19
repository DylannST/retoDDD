package domain.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

public class Genero implements ValueObject<String> {

    private final String tipo;

    public Genero(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String value() {
        return tipo;
    }
}
