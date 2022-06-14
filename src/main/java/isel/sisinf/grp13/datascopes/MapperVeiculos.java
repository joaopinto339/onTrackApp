package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.interfaces.IMapper;
import isel.sisinf.grp13.model.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperVeiculos implements IMapper<Veiculo, String> {
    @Override
    public String create(Veiculo v) throws Exception {
        try (DataScopeVeiculos ds = new DataScopeVeiculos()){
            EntityManager em = ds.getEntityManager();
            //em.getTransaction().begin();
            em.persist(v);
            ds.validateWork();
            return v.getMatricula();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public Veiculo read(String mat) throws Exception {
        try (DataScopeClientes ds = new DataScopeClientes()){
            EntityManager em = ds.getEntityManager();
            Veiculo v =  em.find(Veiculo.class, mat);
            ds.validateWork();
            return v;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Veiculo v) throws Exception {

    }

    @Override
    public void delete(Veiculo v) throws Exception {
        try (DataScopeClientes ds = new DataScopeClientes()){
            EntityManager em = ds.getEntityManager();
            em.flush();
            Veiculo v1 = em.find(Veiculo.class, v.getMatricula(), LockModeType.PESSIMISTIC_WRITE );
            if (v1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(v1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

