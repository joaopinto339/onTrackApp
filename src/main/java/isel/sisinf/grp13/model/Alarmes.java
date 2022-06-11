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

}
