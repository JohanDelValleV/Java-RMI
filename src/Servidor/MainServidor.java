/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author johan
 */
public class MainServidor {
    public static void main(String[] args){
        try {
            Registry miRegistry = LocateRegistry.createRegistry(1234);
            miRegistry.rebind("Mail", new ServerImplements());
            System.out.println("Server ON");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
