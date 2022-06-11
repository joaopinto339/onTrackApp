package isel.sisinf.grp13.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Frota {
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Veiculo matricula;//TODO chaves compostas -> verificar

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Cliente clienteId;

    public Veiculo getMatricula() {
        return matricula;
    }

    public void setMatricula(Veiculo matricula) {
        this.matricula = matricula;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }
}
