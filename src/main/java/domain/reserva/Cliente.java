package domain.reserva;

import co.com.sofka.domain.generic.Entity;
import domain.generalvalues.Nombre;
import domain.reserva.values.ClienteId;
import domain.reserva.values.Edad;
import domain.reserva.values.Estado;

import java.util.Objects;


public class Cliente extends Entity<ClienteId> {

    private Estado estado;
    private Edad edad;
    private Nombre nombreCliente;

    public Cliente(ClienteId clienteId, Estado estado, Edad edad, Nombre nombreCliente) {
        super(clienteId);
        this.estado = Objects.requireNonNull(estado, "el estado de cliente esta nulo");
        this.edad = Objects.requireNonNull(edad, "la edad del cliente esta nulo");
        this.nombreCliente = Objects.requireNonNull(nombreCliente, "el nombre del cliente esta nulo");
    }

    public void actualizarEstado(Estado estado) {
        this.estado = Objects.requireNonNull(estado, "el estado nuevo a actualizar del cliente esta nulo");
    }


    public Estado getEstado() {
        return estado;
    }

    public Edad getEdad() {
        return edad;
    }

    public Nombre getNombreCliente() {
        return nombreCliente;
    }
}
