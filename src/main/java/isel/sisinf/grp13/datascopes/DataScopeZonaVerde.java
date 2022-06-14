package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.model.ZonaVerde;

public class DataScopeZonaVerde extends AbstractDataScope implements AutoCloseable{

    public DataScopeZonaVerde(){
        super();
    }

    public void insertZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().create(zv);
    }
}
