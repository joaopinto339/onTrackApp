package isel.sisinf.grp13.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;

@Embeddable
public class FrotaPk implements Serializable {
    @JoinColumn(name = "matricula")
    private String matricula;
    @JoinColumn(name = "id")
    private int clientid;

    public FrotaPk(String v, int c) {
        this.matricula = v;
        this.clientid = c;
    }

    public FrotaPk() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(Veiculo veiculo) {
        this.matricula = veiculo.getMatricula();
    }

    public int getClientId() {
        return clientid;
    }

    public void setClientid(Cliente cliente) {
        this.clientid = cliente.getId();
    }
}
