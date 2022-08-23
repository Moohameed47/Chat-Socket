package Operations;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operation extends Remote {

    public int SUM(int a, int b) throws RemoteException;

    public int SUB(int a, int b) throws RemoteException;

    public int MUL(int a, int b) throws RemoteException;

    public int DIV(int a, int b) throws RemoteException;
}
