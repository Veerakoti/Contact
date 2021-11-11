package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.model.Contact;
@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender sender;
	
	public boolean sendUserAccUnlockEmail(Contact contact)  {
	//	boolean send=false;
		try {
			MimeMessage createMimeMessage = sender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(createMimeMessage);
			helper.setTo("kotireddy.vadicharla@gmail.com");
			helper.setSubject("Unlock user account");
			helper.setText(getUnlockAccEmailBody(contact),true);
			sender.send(createMimeMessage);
			return true;
			//System.out.println(send);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return false;
	}

	private String getUnlockAccEmailBody(Contact contact) throws IOException {
		StringBuffer buffer=new StringBuffer("");
		FileReader reader=new FileReader("Unlock-email.txt");
		BufferedReader bufferedReader=new BufferedReader(reader);
		String line=bufferedReader.readLine();
		while(line!=null) {
			buffer.append(line);
			line=bufferedReader.readLine();
		}
		bufferedReader.close();
		String mailBody=buffer.toString();
		mailBody=mailBody.replace("{FNAME}", contact.getFirstName());
		mailBody=mailBody.replace("{LNAME}", contact.getLastName());
		mailBody=mailBody.replace("{TEMP-Pwd}", contact.getPazzword());
		mailBody=mailBody.replace("{EMAIL}", contact.getEmail());
		return mailBody;
	}

}
