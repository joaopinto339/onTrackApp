package isel.sisinf.grp13.businesslogic;

import isel.sisinf.grp13.datascopes.*;
import isel.sisinf.grp13.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;

public class BLService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("onTrackApp");
    private Scanner scanner = new Scanner(System.in);

    public void insertParticular(){
        EntityManager em = emf.createEntityManager();
        try{
            System.out.println("Nome?");
            String nome = scanner.nextLine();
            System.out.println("Morada?");
            String morada = scanner.nextLine();
            System.out.println("Telefone?");
            String telefone = scanner.next();
            System.out.println("Nif?");
            int nif = scanner.nextInt();
            System.out.println("CC?");
            int cc = scanner.nextInt();
            System.out.println("Reference?");
            String referencia = scanner.next();
            int ref = 0;
            if(!referencia.equals("null")) ref = Integer.parseInt(referencia); //TODO rever
            System.out.println(ref);
            Particular p = new Particular(nome, morada, telefone, nif, ref, cc);
            p.insertParticular(p, em);
            System.out.println(p);
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "catch");
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void removeParticular(){
        EntityManager em = emf.createEntityManager();
        try{
            System.out.println("ClientId?");
            int clientId = scanner.nextInt();
            Particular p = new Particular();
            p.removeParticular(clientId, em);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void updateParticular(){
        EntityManager em = emf.createEntityManager();
        try{
            System.out.println("ClientID?");
            int clientId = scanner.nextInt();
            scanner.nextLine(); //TODO weird bug que nao dava para inserir morada
            System.out.println("Morada?");
            String morada = scanner.nextLine();
            System.out.println("Telefone?");
            String telefone = scanner.nextLine();
            Particular p = new Particular();
            p.updateParticular(clientId, morada, telefone, em);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void getTotalAlarms(){
        EntityManager em = emf.createEntityManager();
        try{
            Alarmes a = new Alarmes();
            a.getAlarms(em);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void processRegistos(){
        EntityManager em = emf.createEntityManager();
        try{
            RegistoNaoProcessado rnp = new RegistoNaoProcessado();
            rnp.processRecords(em);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void insertVeiculo(){
        EntityManager em = emf.createEntityManager();
        try{
            List data = vehicleInput();
            Veiculo v = (Veiculo) data.get(1);
            v.insertVeiculoProcedure((int) data.get(0), v, (ZonaVerde) data.get(2), em);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }



    public void getAlarmeView(){
        EntityManager em = emf.createEntityManager();
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void eraseInvalids(){
        EntityManager em = emf.createEntityManager();
        try{
            RegistoNaoProcessado rnp = new RegistoNaoProcessado();
            rnp.eraseInvalids(em);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void createVeiculo() throws Exception {
        //EntityManager em = emf.createEntityManager();
        try{
            List data = vehicleInput();
            MapperClientes mc = new MapperClientes();
            Cliente c = mc.read((int) data.get(0));
            RepositoryFrotas rf = new RepositoryFrotas();
            if(rf.getFrotasByClient(c).size() >= 3)
                throw new Exception("Cliente ja tem o numero maximo de frotas");
            if(c == null) throw new Exception("Client id not found");
            Veiculo v = (Veiculo) data.get(1);
            if(v == null) throw new Exception("Veiculo null");
            MapperVeiculos mv = new MapperVeiculos();
            mv.create(v);
            FrotaPk fpk = new FrotaPk(v.getMatricula(), c.getId());
            Frota f = new Frota(fpk);
            MapperFrotas mf = new MapperFrotas();
            mf.create(f);
            ZonaVerde zv = (ZonaVerde) data.get(2);
            if(zv == null) throw new Exception("Zona Verde null");
            MapperZonaVerde mzv = new MapperZonaVerde();
            mzv.create(zv);
        }
        catch (Exception ignored){

        }

    }

    //public void shutdown(){
        //emf.close();
    //}


    /* Aux methods */
    private List vehicleInput() {
        System.out.println("ClienteId?");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Matricula?");
        String matricula = scanner.nextLine();
        System.out.println("Nome de Condutor?");
        String nomeCondutor = scanner.nextLine();
        System.out.println("Contacto?");
        String contacto = scanner.nextLine();
        System.out.println("Estado?");
        String state = scanner.nextLine();
        System.out.println("Latitude, longitude, raio");
        int lat = scanner.nextInt();
        int lon = scanner.nextInt();
        int raio = scanner.nextInt();
        Veiculo v = new Veiculo(matricula,nomeCondutor,state,contacto);
        ZonaVerde zv = new ZonaVerde(lat, lon, raio);
        List data = List.of(clienteId, v, zv);
        return data;
    }
}
