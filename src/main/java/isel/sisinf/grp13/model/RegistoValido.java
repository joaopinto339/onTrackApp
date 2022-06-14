package isel.sisinf.grp13.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "registosvalidos")
public class RegistoValido {
    @Id
    private int id;
    private int latitude;
    private int longitude;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Gps gps;
    private Timestamp marcaTemporal;

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
}
