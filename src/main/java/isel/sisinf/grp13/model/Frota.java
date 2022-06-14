package isel.sisinf.grp13.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Frota {
    @EmbeddedId
    private FrotaPk id;

    public Frota(FrotaPk id) {
        this.id = id;
    }

    public Frota() {}

    public FrotaPk getId() {
        return id;
    }

    public void setId(FrotaPk id) {
        this.id = id;
    }
}
