package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class PwdUtils {
	private static final String ALPHA_NUMERIC_PWD="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String generateTempPwd(int count) {
		StringBuilder builder=new StringBuilder();
		while(count-- !=0) {
			int character=(int) (Math.random() * ALPHA_NUMERIC_PWD.length());
			builder.append(ALPHA_NUMERIC_PWD.charAt(character));
		}
		return builder.toString();
	}
}
