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
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class ClaseRemota 
extends java.rmi.server.UnicastRemoteObject 
implements Interfaz
{
    private String remitente;
    private String destinatario;
    private String asunto;
    private String mensaje;

    public ClaseRemota() throws java.rmi.RemoteException{
        super();
    }

    public void setRemitente(String remitente){
        this.remitente=remitente;
    }
    public void setDestinatario(String destinatario){
        this.destinatario=destinatario;
    }
    public void setAsunto(String asunto){
        this.asunto=asunto;
    }
    public void setMensaje(String mensaje){
        this.mensaje=mensaje;
    }
    public void enviar(){
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", this.remitente);
        props.put("mail.smtp.clave", "ifmuqpplkiyfmghi");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
        message.setFrom(new InternetAddress(this.remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.destinatario));   //Se podrían añadir varios de la misma manera
        message.setSubject(this.asunto);
        message.setText(this.mensaje);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", this.remitente, "ifmuqpplkiyfmghi");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("Exitoso");
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
}