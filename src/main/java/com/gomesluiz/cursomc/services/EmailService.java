package com.gomesluiz.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gomesluiz.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationMail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
