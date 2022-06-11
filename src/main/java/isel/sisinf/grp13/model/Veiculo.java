package isel.sisinf.grp13.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    private String matricula;
    private String nomeCondutor;
    private String estado;
    private String contactoCondutor;
    private int numAlarmes;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Gps gps;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContactoCondutor() {
        return contactoCondutor;
    }

    public void setContactoCondutor(String contactoCondutor) {
        this.contactoCondutor = contactoCondutor;
    }

    public int getNumAlarmes() {
        return numAlarmes;
    }

    public void setNumAlarmes(int numAlarmes) {
        this.numAlarmes = numAlarmes;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }
}
