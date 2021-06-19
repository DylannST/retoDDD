package domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Silla implements ValueObject<Silla.Values> {

    private final String puesto;
    private final double valor;
    private final boolean vip;

    public Silla(String puesto, double valor, boolean vip) {
        this.puesto = Objects.requireNonNull(puesto, "el puesto esta nulo");
        this.valor = Objects.requireNonNull(valor, "el valor de la silla esta nulo");
        this.vip = Objects.requireNonNull(vip, "el vip de las silla esta nulo");
    }


    @Override
    public Values value() {
        return new Values() {
            @Override
            public String puesto() {
                return puesto;
            }

            @Override
            public double valor() {
                return valor;
            }

            @Override
            public boolean vip() {
                return vip;
            }

        };
    }

    public interface Values {
        String puesto();

        double valor();

        boolean vip();
    }
}
