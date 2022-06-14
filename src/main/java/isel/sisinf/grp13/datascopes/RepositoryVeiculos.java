package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IRepository;
import isel.sisinf.grp13.model.Veiculo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryVeiculos implements IRepository<Veiculo, String> {
    @Override
    public Veiculo find(String mat) throws Exception {
        MapperVeiculos m = new MapperVeiculos();
        try {
            return m.read(mat);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Veiculo> getAll() throws Exception {
        try(DataScopeVeiculos ds = new DataScopeVeiculos()){
            EntityManager em = ds.getEntityManager();
            List<Veiculo> list = em.createQuery("select v from Veiculo v", Veiculo.class).getResultList();
            ds.validateWork();
            return list;
        }
    }


    @Override
    public void add(Veiculo v) throws Exception {
        MapperVeiculos m = new MapperVeiculos();
        try {
            m.create(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Veiculo v) throws Exception {
        MapperVeiculos m = new MapperVeiculos();
        try {
            m.delete(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(Veiculo e) throws Exception {

    }
}
