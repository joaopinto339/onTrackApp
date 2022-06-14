package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IMapper;
import isel.sisinf.grp13.model.ZonaVerde;
import jakarta.persistence.EntityManager;

public class MapperZonaVerde implements IMapper<ZonaVerde, Integer> {
    @Override
    public Integer create(ZonaVerde zv) throws Exception {
        try(DataScopeZonaVerde ds = new DataScopeZonaVerde()){
            EntityManager em = ds.getEntityManager();
            em.persist(zv);
            ds.validateWork();
            return zv.getId();
        }catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ZonaVerde read(Integer k) throws Exception {
        return null;
    }

    @Override
    public void update(ZonaVerde e) throws Exception {

    }

    @Override
    public void delete(ZonaVerde e) throws Exception {

    }
}
