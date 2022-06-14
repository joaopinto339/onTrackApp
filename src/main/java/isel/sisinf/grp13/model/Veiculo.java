package isel.sisinf.grp13.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    private String matricula;
    private String nomeCondutor;
    private String estado;
    private String contactoCondutor;
    private int numAlarmes;

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


    public void insertVeiculoProcedure(int clientId, Veiculo v, ZonaVerde zv, EntityManager em){
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

    public void createVeiculo(int clientId, Veiculo v, ZonaVerde zv, EntityManager em) throws Exception {
        em.getTransaction().begin();
        Cliente c = em.getReference(Cliente.class, clientId);

        Query q = em.createNativeQuery("SELECT id from cliente where id = ?1");
        q.setParameter(1,clientId);
        int t = q.executeUpdate();
        List res = q.getResultList();
        if(res.size() == 0) throw new Exception("User not found");
        int cid = (int) res.get(0);
        q = em.createNativeQuery("SELECT clientId FROM PARTICULAR WHERE clientID = ?2");
        q.setParameter(2, clientId);
        boolean particular = true;
        q.executeUpdate();
        res = q.getResultList();
        if(res.size() == 0) particular = false;
        if(particular){
            q = em.createNativeQuery("SELECT clientId FROM frota WHERE clientID = ?3");
            q.setParameter(3, clientId);
            q.executeUpdate();
            res = q.getResultList();
            if(res.size() >= 3) throw new Exception("Too many vehicles associated with this ID");
        }
        q = em.createNativeQuery("INSERT INTO Veiculo (matricula, nomeCondutor, contactoCondutor, estado) " +
                "VALUES(?4, ?5, ?6, ?7)");
        q.setParameter(4, v.matricula);
        q.setParameter(5, v.nomeCondutor);
        q.setParameter(6, v.contactoCondutor);
        q.setParameter(7, v.estado);
        q.executeUpdate();
        q = em.createNativeQuery("INSERT INTO Frota(clientID, matricula)" +
                "VALUES(?8, ?9)");
        q.setParameter(8, clientId);
        q.setParameter(9, v.matricula);
        if(zv != null){
            q = em.createNativeQuery("INSERT INTO ZonaVerde(latitude, longitude, raio)" +
                    "VALUES(?10, ?11, ?12)");
            q.setParameter(10, zv.getLatitude());
            q.setParameter(11, zv.getLongitude());
            q.setParameter(12, zv.getRaio());
            q.executeUpdate();
        }
    }
}
