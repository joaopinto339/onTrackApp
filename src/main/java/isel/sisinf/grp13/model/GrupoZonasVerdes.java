package isel.sisinf.grp13.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grupozonasverdes")
public class GrupoZonasVerdes {
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Veiculo matricula;//TODO chaves compostas -> verificar

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private ZonaVerde zonaVerdeId;

    public Veiculo getMatricula() {
        return matricula;
    }

    public void setMatricula(Veiculo matricula) {
        this.matricula = matricula;
    }

    public ZonaVerde getZonaVerdeId() {
        return zonaVerdeId;
    }

    public void setZonaVerdeId(ZonaVerde zonaVerdeId) {
        this.zonaVerdeId = zonaVerdeId;
    }
}
