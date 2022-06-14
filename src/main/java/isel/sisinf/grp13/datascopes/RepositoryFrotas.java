package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IRepositorySurrogate;
import isel.sisinf.grp13.model.Cliente;
import isel.sisinf.grp13.model.Frota;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryFrotas implements IRepositorySurrogate<Frota,Integer, String> {

    @Override
    public List<Frota> getAll() throws Exception {
        return null;
    }

    @Override
    public Frota find(Integer k1, String k2) throws Exception {
        return null;
    }

    @Override
    public void add(Frota f) throws Exception {
        MapperFrotas m = new MapperFrotas();
        try {
            m.create(f);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Frota entity) throws Exception {

    }

    @Override
    public void save(Frota e) throws Exception {

    }

    public List<Frota> getFrotasByClient(Cliente c) throws Exception {
        try(DataScopeFrota ds = new DataScopeFrota()){
            EntityManager em = ds.getEntityManager();
            List<Frota> list = em.createQuery("select f from Frota f", Frota.class).getResultList();
            ds.validateWork();
            list.removeIf(f -> f.getId().getClientId() != c.getId());
            return list;
        }

    }
}
