package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.model.Cliente;
import isel.sisinf.grp13.model.Frota;

import java.util.List;
import java.util.Map;

public class DataScopeFrota extends AbstractDataScope implements AutoCloseable{

    public DataScopeFrota(){
        super();
    }
    public void insertFrota(Frota f) throws Exception {
        new MapperFrotas().create(f);
    }

    public List<Frota> getFrotasByClient(Cliente c) throws Exception {
        return new RepositoryFrotas().getFrotasByClient(c);
    }
}
