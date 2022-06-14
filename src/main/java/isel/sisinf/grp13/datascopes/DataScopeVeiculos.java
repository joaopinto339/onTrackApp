package isel.sisinf.grp13.datascopes;

import isel.sisinf.grp13.model.Veiculo;

public class DataScopeVeiculos extends AbstractDataScope implements AutoCloseable{
    public DataScopeVeiculos() {
        super();
    }

    public void insertVeiculo(Veiculo v) throws Exception {
        new MapperVeiculos().create(v);
    }

    public Veiculo findVeiculo(String mat) throws Exception  {
        return new MapperVeiculos().read(mat);
    }

    public void deleteVeiculo(Veiculo v) throws Exception {
        new MapperVeiculos().delete(v);
    }
    public void deleteVeiculoByKey(String mat) throws Exception {
        Veiculo v = new Veiculo();
        v.setMatricula(mat);
        new MapperVeiculos().delete(v);
    }

    public void updateVeiculo(Veiculo v) throws Exception {
        new MapperVeiculos().update(v);
    }

}
