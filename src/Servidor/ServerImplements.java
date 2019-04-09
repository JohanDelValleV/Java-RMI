/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import RMI.RemoteInterface;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author johan
 */
public class ServerImplements extends UnicastRemoteObject implements RemoteInterface{
    private String usuario;
    private String contrasenia;
    private String nombreArchivo;
    private String mensaje;
    private String asunto;
    private String destino;
    private String rutaArchivo;
    
    public ServerImplements() throws java.rmi.RemoteException {
        super();
    }
    
    @Override
    public String getDestino() throws java.rmi.RemoteException {
        return destino;
    }

    @Override
    public void setDestino(String destino) throws java.rmi.RemoteException {
        this.destino = destino;
    }
    
    @Override
    public String getUsuario() throws java.rmi.RemoteException {
        return usuario;
    }

    @Override
    public void setUsuario(String usuario) throws java.rmi.RemoteException {
        this.usuario = usuario;
    }

    @Override
    public String getContrasenia() throws java.rmi.RemoteException {
        return contrasenia;
    }

    @Override
    public void setContrasenia(String contrasenia) throws java.rmi.RemoteException {
        this.contrasenia = contrasenia;
    }

    @Override
    public String getNombreArchivo() throws java.rmi.RemoteException {
        return nombreArchivo;
    }

    @Override
    public void setNombreArchivo(String nombreArchivo) throws java.rmi.RemoteException {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String getMensaje() throws java.rmi.RemoteException {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) throws java.rmi.RemoteException {
        this.mensaje = mensaje;
    }

    @Override
    public String getAsunto() throws java.rmi.RemoteException {
        return asunto;
    }

    @Override
    public void setAsunto(String asunto) throws java.rmi.RemoteException {
        this.asunto = asunto;
    }

    @Override
    public String getRutaArchivo() throws java.rmi.RemoteException {
        return rutaArchivo;
    }

    @Override
    public void setRutaArchivo(String rutaArchivo) throws java.rmi.RemoteException {
        this.rutaArchivo = rutaArchivo;
    }
    
    @Override
    public boolean enviarCorreo() {
        try {
            Properties prop= new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.setProperty("mail.smtp.starttls.enable", "true");
            prop.setProperty("mail.smtp.port", "587");
            prop.setProperty("mail.smtp.user", this.getUsuario());
            prop.setProperty("mail.smtp.auth", "true");

            Session sesion= Session.getDefaultInstance(prop, null);
            BodyPart texto= new MimeBodyPart();
            texto.setText(this.getMensaje());
            BodyPart adjunto= new MimeBodyPart();
            MimeMultipart m= new MimeMultipart();
            m.addBodyPart(texto);
            MimeMessage mensaje= new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(this.getUsuario()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getDestino()));
            mensaje.setSubject(this.getAsunto());
            mensaje.setContent(m);

            Transport t= sesion.getTransport("smtp");
            t.connect(this.getUsuario(), this.getContrasenia());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;
            
            
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            System.out.println("Error" + e);
            return false;
        }
    }
}
