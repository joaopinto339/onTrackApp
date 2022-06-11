package isel.sisinf.grp13;

import isel.sisinf.grp13.businesslogic.BLService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args){
        BLService blService = new BLService();
        //blService.insertParticular();
        blService.removeParticular();
    }
}
