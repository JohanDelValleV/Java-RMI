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
public interface Interfaz extends java.rmi.Remote{

    public void setRemitente(String remitente) throws java.rmi.RemoteException;
    public void setDestinatario(String destinatario) throws java.rmi.RemoteException;
    public void setAsunto(String asunto) throws java.rmi.RemoteException;
    public void setMensaje(String mensaje) throws java.rmi.RemoteException;
    public void enviar() throws java.rmi.RemoteException;
}