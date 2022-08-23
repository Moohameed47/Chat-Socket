/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerSide;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;
import java.rmi.RemoteException;

/**
 *
 * @author DE
 */
public class Server {

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Registry r = LocateRegistry.createRegistry(3539);
            r.rebind("calc", calculator);
            System.out.println("Binding complete…\n");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
