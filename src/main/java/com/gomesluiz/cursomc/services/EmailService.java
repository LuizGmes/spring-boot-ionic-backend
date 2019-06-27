package com.gomesluiz.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.gomesluiz.cursomc.domain.Cliente;
import com.gomesluiz.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationMail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}
