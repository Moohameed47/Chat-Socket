/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSide;

import Operations.Operation;
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author DE
 */
public class Client {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Operation P = (Operation) Naming.lookup("rmi://127.0.0.1:3539/calc");
            System.out.printf("Enter First Number:  ");
            int a = in.nextInt();
            System.out.printf("Enter Second Number:  ");
            int b = in.nextInt();
            System.out.println("SUM = " + P.SUM(a, b));
            System.out.println("SUB = " + P.SUB(a, b));
            System.out.println("MUL = " + P.MUL(a, b));
            System.out.println("DIV = " + P.DIV(a, b));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}