package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.model.Cliente;

import java.util.List;

public class DataScopeClientes extends AbstractDataScope implements AutoCloseable {

    public DataScopeClientes() {
        super();
    }

    public List<Cliente> getAllClientes() throws Exception {
        return new RepositoryClientes().getAll();
    }

    public Cliente findCliente(int Id) throws Exception  {
        return new MapperClientes().read(Id);
    }

    public void deleteCliente(Cliente c) throws Exception {
        new MapperClientes().delete(c);
    }

    public void deleteClienteByKey(int Id) throws Exception {
        Cliente c = new Cliente();
        c.setId(Id);
        new MapperClientes().delete(c);
    }

    public void updateCliente(Cliente c) throws Exception {
        new MapperClientes().update(c);
    }

    public void insertCliente(Cliente c) throws Exception {
        new MapperClientes().create(c);
    }




}
