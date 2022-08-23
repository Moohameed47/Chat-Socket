/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerSide;

import Operations.Operation;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements Operation {

    Calculator() throws RemoteException {
    }

    @Override
    public int SUM(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int SUB(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int MUL(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int DIV(int a, int b) throws RemoteException {
        return a / b;
    }

}
