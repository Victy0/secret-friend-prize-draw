package com.victor.secretfriend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService
{
    private final String hostSmtp;

    private final String passwordSmtp;

    private final String port;

    private final String usernameSmtp;

    public EmailService(
        @Value( "${smtp.username}" ) final String usernameSmtp,
        @Value( "${smtp.password}" ) final String passwordSmtp,
        @Value( "${smtp.host}" ) final String hostSmtp,
        @Value( "${smtp.port}" ) final String port)
    {
        this.usernameSmtp = usernameSmtp;
        this.passwordSmtp = passwordSmtp;
        this.hostSmtp = hostSmtp;
        this.port = port;
    }

    public void sendEmail(final String to, final String subject, final String content)
    {
        final Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put( "mail.smtp.host", this.hostSmtp);
        props.put( "mail.smtp.port", this.port);
        props.put( "mail.smtp.auth", "true");

        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        final String username = this.usernameSmtp;
        final String password = this.passwordSmtp;
        final Session session = Session.getInstance( props, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication( username, password );
            }
        } );

        try
        {
            final MimeMessage message = new MimeMessage( session );

            message.setRecipient( Message.RecipientType.TO, new InternetAddress( to ) );

            message.setSubject( subject );

            message.setText( content );

            Transport.send( message );
        }
        catch ( final MessagingException e )
        {
            System.out.println("Erro e-mail:" + e.getMessage());
        }
    }
}
