package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mail.model.EmailRequest;
import com.mail.service.EmailService;

@RestController
@CrossOrigin
public class EmaiController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		
		return "This is the rest api";
	}
	
	
	// api to send mail
	@RequestMapping(value = "/sendemail",method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		
	
		
		System.out.println(request);
	      boolean result =this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.geTo());
		if(result) 
		{
			return ResponseEntity.ok("don...");
			
		}else {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body("Email not send....  ");
			
		}
		
	}

}
