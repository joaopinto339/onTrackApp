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

    public Veiculo(String matricula, String nomeCondutor, String estado, String contactoCondutor) {
        this.matricula = matricula;
        this.nomeCondutor = nomeCondutor;
        this.estado = estado;
        this.contactoCondutor = contactoCondutor;
    }

    public Veiculo() {}

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

    public void insertVeiculo(int clientId, Veiculo v, ZonaVerde zv, EntityManager em){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("call create_vehicle(?1,?2,?3,?4,?5,?6,?7,?8)");
        q.setParameter(1, clientId);
        q.setParameter(2, v.matricula);
        q.setParameter(3, v.nomeCondutor);
        q.setParameter(4, v.contactoCondutor);
        q.setParameter(5, v.estado);
        q.setParameter(6, zv.getLatitude());
        q.setParameter(7, zv.getLongitude());
        q.setParameter(8, zv.getRaio());
        q.executeUpdate();
        em.getTransaction().commit();
    }
}
