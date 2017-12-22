package sw.gmit.ie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.*;
import java.util.*;

//Remote Interface for app
public interface DictonaryService extends Remote {
	public String lookup(String s) throws RemoteException, Exception;
	public void openFile()throws RemoteException, Exception;
	public String readFile(String s)throws RemoteException, Exception;
	public void closeFile()throws RemoteException, Exception;
	//public void doFileStuff();

}
