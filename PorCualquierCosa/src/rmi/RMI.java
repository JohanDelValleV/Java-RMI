/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.registry.LocateRegistry;

/**
 *
 * @author replicacion
 */
public class RMI{
    public static void main(String args[]){
        try
        {
            Interfaz mir = new ClaseRemota();
            LocateRegistry.createRegistry(8080);
            java.rmi.Naming.rebind("rmi://" + java.net.InetAddress.getLocalHost().getHostAddress() +
                                    ":" + "8080" + "/PruebaRMI", mir);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
