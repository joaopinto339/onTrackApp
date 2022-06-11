package isel.sisinf.grp13.model;

import jakarta.persistence.*;

public class Alarmes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private RegistoValido idRegisto;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Veiculo matricula;//TODO chaves compostas -> verificar

    public Alarmes() {}

    public String getAlarms(EntityManager em){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("select * from alarms");
        //Query query = em.createQuery("select * from alarms");
        String a = q.getResultList().get(1).toString();
        //String a = q.getSingleResult().toString();
        System.out.println(q.getResultList());
        return a;
    }
}
