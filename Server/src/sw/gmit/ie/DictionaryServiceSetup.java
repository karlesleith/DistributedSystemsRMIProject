package sw.gmit.ie;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DictionaryServiceSetup extends DictionaryServiceImpl{

	public DictionaryServiceSetup(){
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) throws Exception {

        System.out.println("RMI DictionnaryService Server  has started!");
        
        //Instantiate the server
        DictionaryServiceImpl serverObj = new DictionaryServiceImpl();
        
        try { //special exception handler for registry creation
        	
        	DictonaryService stub = (DictonaryService) UnicastRemoteObject.exportObject(serverObj,0);
            Registry reg;
            try {
            	reg = LocateRegistry.createRegistry(1099);
                System.out.println("Java RMI Reg created in DictionaryServiceSetup");

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	reg = LocateRegistry.getRegistry();
            }
        	reg.rebind("RMIServer", stub);

        } catch (RemoteException e) {
        	e.printStackTrace();
        }
    }

}
