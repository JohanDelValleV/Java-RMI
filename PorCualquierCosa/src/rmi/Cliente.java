/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author replicacion
 */
public class Cliente{
    public static void main(String args[]){
       try {
        Interfaz inf = (Interfaz)java.rmi.Naming.lookup("rmi://" + 
        java.net.InetAddress.getLocalHost().getHostAddress() + ":" + "8080" + "/PruebaRMI");
        inf.setRemitente("arturo.lessieur@gmail.com");
        inf.setDestinatario("173228@ids.upchiapas.edu.mx");
        inf.setAsunto("Test");
        inf.setMensaje("Hola");
        inf.enviar();
       } catch (Exception e) {
           //TODO: handle exception
       }
    }
}