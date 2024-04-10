package com.example.SendMailSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.SendMailSpringboot.service.HomeService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SendMailSpringbootApplication {
    
	@Autowired
	HomeService homeService;

	public static void main(String[] args) {
		SpringApplication.run(SendMailSpringbootApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		homeService.sendSimpleMail("receiver@gmail.com",
//				"This is test body of learn Code With Sankalp",
//				"This is test subject for Learn Code With Sankalp");
		
		homeService.sendMailWithAtchment("receiver@gmail.com",
				"This is test body of learn Code With Sankalp",
				"This is test subject for Learn Code With Sankalp", "F:\\download.jfif");
	}

}
