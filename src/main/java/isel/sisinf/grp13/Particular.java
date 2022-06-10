package isel.sisinf.grp13;

import jakarta.persistence.*;

public class Particular extends Cliente {
    @Id
    private int cc;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Cliente clienteId; //TODO @Embedded e ver cascadeType= Persist

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }
}
