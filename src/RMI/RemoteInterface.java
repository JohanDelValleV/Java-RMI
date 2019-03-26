/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import Servidor.ServerImplements;
import java.rmi.Remote;

/**
 *
 * @author johan
 */
public interface RemoteInterface extends Remote{
    public String getDestino() throws java.rmi.RemoteException;
    public void setDestino(String destino) throws java.rmi.RemoteException;
    public String getUsuario() throws java.rmi.RemoteException;
    public void setUsuario(String usuario) throws java.rmi.RemoteException;
    public String getContrasenia() throws java.rmi.RemoteException;
    public void setContrasenia(String contrasenia) throws java.rmi.RemoteException;
    public String getNombreArchivo() throws java.rmi.RemoteException;
    public void setNombreArchivo(String nombreArchivo) throws java.rmi.RemoteException;
    public String getMensaje() throws java.rmi.RemoteException;
    public void setMensaje(String mensaje) throws java.rmi.RemoteException;
    public String getAsunto() throws java.rmi.RemoteException;
    public void setAsunto(String asunto) throws java.rmi.RemoteException;
    public String getRutaArchivo() throws java.rmi.RemoteException;
    public void setRutaArchivo(String rutaArchivo) throws java.rmi.RemoteException;
    public boolean enviarCorreo() throws java.rmi.RemoteException;
}
