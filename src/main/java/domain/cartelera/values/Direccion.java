package domain.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Props> {

    private final String direccion;
    private final String municipio;

    public Direccion(String direccion, String municipio) {
        this.direccion = Objects.requireNonNull(direccion, "La direccion esta nula");
        this.municipio = Objects.requireNonNull(municipio, "el municipio esta nulo");
    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public String municipio() {
                return municipio;
            }

        };
    }

    public interface Props {
        String direccion();

        String municipio();
    }
}
