package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generalvalues.Nombre;
import domain.reserva.Cliente;
import domain.reserva.values.ClienteId;
import domain.reserva.values.Edad;
import domain.reserva.values.Estado;

public class ClienteActualizado extends DomainEvent {

    private final ClienteId clienteId;
    private final Estado estado;
    private final Edad edad;
    private final Nombre nombreCliente;

    public ClienteActualizado(ClienteId clienteId, Estado estado, Edad edad, Nombre nombreCliente) {
        super("domain.reserva.ClienteActualizado");
        this.clienteId = clienteId;
        this.estado = estado;
        this.edad = edad;
        this.nombreCliente = nombreCliente;
    }

    public Cliente clienteActualizado() {
        return new Cliente(this.clienteId, this.estado, this.edad, this.nombreCliente);
    }

    public ClienteId getClienteId() {
        return clienteId;
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
