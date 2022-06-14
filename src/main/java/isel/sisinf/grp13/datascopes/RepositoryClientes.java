package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IRepository;
import isel.sisinf.grp13.model.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryClientes implements IRepository<Cliente, Integer> {

    public Cliente find(Integer Id) throws Exception {
        MapperClientes m = new MapperClientes();

        try
        {
            return m.read(Id);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public List<Cliente> getAll() throws Exception {
        try (DataScopeClientes ds = new DataScopeClientes())
        {
            EntityManager em = ds.getEntityManager();
            List<Cliente> l = em.createQuery("select c from Cliente c",Cliente.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void add(Cliente c) throws Exception {
        MapperClientes m = new MapperClientes();

        try
        {
            m.create(c);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }



    public void save(Cliente c) throws Exception {

    }

    public void delete(Cliente c) throws Exception {
        MapperClientes m = new MapperClientes();

        try
        {
            m.delete(c);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }


}
