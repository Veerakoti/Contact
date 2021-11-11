package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.constants.AppConstants;
import com.example.demo.model.Contact;
import com.example.demo.model.UnlockAcc;
import com.example.demo.service.ContactService;

@Controller
public class UnlockAccController {

	private static final Logger logger = LoggerFactory.getLogger(UnlockAccController.class);

	@Autowired
	private  ContactService service;

	@RequestMapping(value = "/unlockAcc")
	public String displayunlockAcc(@RequestParam("email") String email,Model model) {
		//model.addAttribute("email", email);
		logger.debug(AppConstants.METHOD_EXE_START);
		UnlockAcc acc=new UnlockAcc();
		acc.setEmail(email);
		model.addAttribute(AppConstants.UNLOCK_KEY, acc);
		logger.debug(AppConstants.METHOD_EXE_ENDED);
		logger.info(AppConstants.UNLOCK_ACC_SUCC);
		return AppConstants.UNLOCK_VIEW;
	}
	@RequestMapping(value = "/unlockaccUser")
	public String unlockUserAcc(@ModelAttribute("unlock") UnlockAcc unlockAcc,Model model) {
		logger.debug(AppConstants.METHOD_EXE_START);
		try {
			Contact contactByTempPwd = service.getContactByTempPwd(unlockAcc.getTempPwd(), unlockAcc.getEmail());
			if(contactByTempPwd!=null) {
				contactByTempPwd.setAccStatus(AppConstants.UNLOCKED_STR);
				contactByTempPwd.setPazzword(unlockAcc.getNewPwd());
				boolean updateUserAcc = service.updateUserAcc(contactByTempPwd);
				if(updateUserAcc) {
					logger.info(AppConstants.UNLOCK_ACC_UPDATED_SUCC); 
					return AppConstants.UNLOCK_ACC_SUCC_VIEW;
				}
				else {
					logger.warn(AppConstants.ACC_NT_UNLOCKED);
				}
			}
			model.addAttribute(AppConstants.ERROR_KEY, AppConstants.ERROR_MSG);

		} catch (Exception e) {
			logger.error(AppConstants.EXCEPTION_STR+e.getMessage());
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED);
		return AppConstants.UNLOCK_VIEW;
	}

}
