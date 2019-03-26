/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import RMI.RemoteInterface;
import Servidor.ServerImplements;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class MainCliente {
    public static void main(String args[]){
        try {
            String remitente = JOptionPane.showInputDialog("Remitente:");
            String destinatario = JOptionPane.showInputDialog("Destinatario:");
            String asunto = JOptionPane.showInputDialog("Asunto:");
            String mensaje = JOptionPane.showInputDialog("Mensaje:");
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1", 1234);
            RemoteInterface miRemote = (RemoteInterface) miRegistro.lookup("Mail");
            miRemote.setUsuario(remitente);
            miRemote.setDestino(destinatario);
            miRemote.setAsunto(asunto);
            miRemote.setMensaje(mensaje);
            miRemote.enviarCorreo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
