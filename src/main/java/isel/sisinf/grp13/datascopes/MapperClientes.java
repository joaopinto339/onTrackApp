package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IMapper;
import isel.sisinf.grp13.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperClientes implements IMapper<Cliente, Integer> {
    @Override
    public Integer create(Cliente c) throws Exception {
        try (DataScopeClientes ds = new DataScopeClientes()){
            EntityManager em = ds.getEntityManager();
            //em.getTransaction().begin();
            em.persist(c);
            ds.validateWork();
            return c.getId();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public Cliente read(Integer id) throws Exception {
        try (DataScopeClientes ds = new DataScopeClientes()){
            EntityManager em = ds.getEntityManager();
            Cliente c =  em.find(Cliente.class, id);
            ds.validateWork();
            return c;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Cliente c) throws Exception {

    }

    @Override
    public void delete(Cliente c) throws Exception {
        try (DataScopeClientes ds = new DataScopeClientes()){
            EntityManager em = ds.getEntityManager();
            em.flush();
            Cliente c1 = em.find(Cliente.class, c.getId(), LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(c1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
