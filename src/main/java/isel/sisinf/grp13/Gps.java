package isel.sisinf.grp13;
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
