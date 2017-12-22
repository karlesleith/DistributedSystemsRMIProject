package sw.gmit.ie;
import java.io.FileNotFoundException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

	public static String run(String q) throws Exception{
		
		Registry registry = LocateRegistry.getRegistry("localhost");
		
		DictonaryService obj = (DictonaryService) registry.lookup("RMIServer");
        String s  = obj.lookup(q); 
		
        return s; 
	}

}
