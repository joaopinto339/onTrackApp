package isel.sisinf.grp13.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class ZonaVerde {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int raio;
    private int latitude;
    private int longitude;

    public ZonaVerde(int latitude, int longitude, int raio) {
        this.raio = raio;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ZonaVerde() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
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


}
