package isel.sisinf.grp13.interfaces;

import java.util.List;

public interface IRepositorySurrogate<Tentity,Tkey1, Tkey2>{
    List<Tentity> getAll() throws Exception;;
    Tentity find(Tkey1 k1, Tkey2 k2) throws Exception;;
    //List<Tentity> Find(Tkey k ,String c); // find by criteria
    void add(Tentity entity) throws Exception;;
    void delete(Tentity entity) throws Exception;;
    void save(Tentity e) throws Exception;;
}
