package isel.sisinf.grp13.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "registosnaoprocessados")
public class RegistoNaoProcessado {
    @Id
    private int id;
    private int latitude;
    private int longitude;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Gps gps;
    private Timestamp marcaTemporal;


    public RegistoNaoProcessado() {}

    public RegistoNaoProcessado(int id, int latitude, int longitude, Gps gps, Timestamp marcaTemporal) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gps = gps;
        this.marcaTemporal = marcaTemporal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    public Timestamp getMarcaTemporal() {
        return marcaTemporal;
    }

    public void setMarcaTemporal(Timestamp marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
    }

    public void processRecords(EntityManager em){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("call processrecords()");
        q.executeUpdate();
        System.out.println("Records processed");
        em.getTransaction().commit();
    }

    public void eraseInvalids(EntityManager em){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("call eraseinvalids()");
        q.executeUpdate();
        System.out.println("Registers invalids older than 15 days deleted");
        em.getTransaction().commit();
    }
}
