package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IMapperSurrogate;
import isel.sisinf.grp13.model.Frota;
import jakarta.persistence.EntityManager;

public class MapperFrotas implements IMapperSurrogate<Frota,Integer,String> {

    @Override
    public Integer create(Frota f) throws Exception {
        try(DataScopeFrota ds = new DataScopeFrota()){
            EntityManager em = ds.getEntityManager();
            em.persist(f);
            ds.validateWork();
            return f.getId().getClientId();
        }
    }

    @Override
    public Frota read(Integer k1, String k2) throws Exception {
        return null;
    }

    @Override
    public void update(Frota e) throws Exception {

    }

    @Override
    public void delete(Frota e) throws Exception {

    }
}
