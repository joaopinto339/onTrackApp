package isel.sisinf.grp13.model;
import jakarta.persistence.*;

@Entity
public class Gps {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
