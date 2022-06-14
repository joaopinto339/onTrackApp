package isel.sisinf.grp13.model;

import jakarta.persistence.*;

@Entity
@Table(name = "institucional")
public class Institucional extends Cliente{
    @Id
    private String nomeContacto;

    public Institucional(String nome, String morada, String telefone, int nif, int ref, String nomeContacto) {
        super(nome, morada, telefone, nif, ref);
        this.nomeContacto = nomeContacto;
    }

    public Institucional() {}

    public String getNomeContacto() {
        return nomeContacto;
    }

    public void setNomeContacto(String nomeContacto) {
        this.nomeContacto = nomeContacto;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Cliente clienteId; //TODO @Embedded e ver cascadeType= Persist

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }
}
