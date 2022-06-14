package isel.sisinf.grp13.model;

import jakarta.persistence.*;

@Entity
@Table(name = "particular")
public class Particular extends Cliente {
    @Id
    private int cc;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Cliente clienteId; //TODO @Embedded e ver cascadeType= Persist

    public Particular() {}

    public Particular(String nome, String morada, String telefone, int nif, int ref, int cc) {
        super(nome, morada, telefone, nif, ref);
        this.cc = cc;
    }

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

    public void insertParticular(Particular p, EntityManager em){
            em.getTransaction().begin();
            Query q = em.createNativeQuery("call insertParticular(?1, ?2, ?3, ?4, ?5, ?6)");
            q.setParameter(1, p.getNome());
            q.setParameter(2, p.getMorada());
            q.setParameter(3, p.getTelefone());
            q.setParameter(4, p.getNif());
            q.setParameter(5, p.cc);
            //int ref = p.getRef();
            //if(ref == 0) q.setParameter(6, null);
            q.setParameter(6, p.getRef());
            q.executeUpdate();
            System.out.println(q.getFirstResult());
            em.getTransaction().commit();
    }

    public void removeParticular(int clientId, EntityManager em){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("call removeparticular(?1)");
        q.setParameter(1, clientId);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void updateParticular(int clientId, String morada, String telefone, EntityManager em){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("call updateparticular(?1, ?2, ?3)");
        q.setParameter(1, clientId);
        if(morada.equals("null")) q.setParameter(2, null);
        else q.setParameter(2, morada);
        if(telefone.equals("null")) q.setParameter(3, null);
        else q.setParameter(3, telefone);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public String toString() {
        return "Particular{" +
                "cc=" + cc +
                ", clienteId=" + clienteId +
                '}';
    }
}
