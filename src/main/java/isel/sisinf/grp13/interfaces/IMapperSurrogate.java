package isel.sisinf.grp13.interfaces;

public interface IMapperSurrogate <Tentity, Tkey1, Tkey2>{
    Tkey1 create(Tentity e) throws Exception;

    Tentity read(Tkey1 k1, Tkey2 k2) throws Exception; // acesso dada a chave

    void update(Tentity e) throws Exception;

    void delete(Tentity e) throws Exception;
}
