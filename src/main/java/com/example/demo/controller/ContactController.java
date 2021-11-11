package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.constants.AppConstants;
import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@Controller
public class ContactController {
	  
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService service;
	@RequestMapping(value = {"/","addContact"})
	public String addContact(Model model) {
		logger.debug(AppConstants.METHOD_EXE_START);
		try {
			Contact contact=new Contact();
			model.addAttribute(AppConstants.CONTACT_MODEL_KEY, contact);
			Map<Integer, String> allCountries = service.getAllCountries();
		//	allCountries.put(1, "india");
			model.addAttribute(AppConstants.COUNTRYS_MODEL_KEY, allCountries);
		} catch (Exception e) {
			logger.error(AppConstants.EXCEPTION_STR+e.getMessage());
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED);
		logger.info(AppConstants.USER_REG_FORM_LOADED);
		return AppConstants.CONTACT_INFO_VIEW;
	}

	@RequestMapping(value = "/userAccReg",method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("contact") Contact contact) {
		logger.debug(AppConstants.METHOD_EXE_START); 
		try {
			service.getAccountReg(contact);
			logger.info(AppConstants.USER_REG_SUCCESS_INFO);
		} catch (Exception e) {
			logger.error(AppConstants.EXCEPTION_STR+e.getMessage());
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED); 
		return AppConstants.USER_ACC_REG_SUCC_VIEW;
	}
	
	@RequestMapping(value = "/getStates",method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer,String> getStatesByCountryId(@RequestParam("cid") Integer countryId){
		logger.debug(AppConstants.METHOD_EXE_START); 
		Map<Integer, String> statesByCountryId = null;
		try {
			statesByCountryId = service.getStatesByCountryId(countryId);
			logger.info(AppConstants.STATE_DETAIS_FOUND);
		} catch (Exception e) {
			logger.error(AppConstants.EXCEPTION_STR+e.getMessage());
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED); 
		return  statesByCountryId;
	}
	@RequestMapping(value = "/getCitys",method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer,String> getCitysByStateId(@RequestParam("sid") Integer stateId){
		Map<Integer, String> citiesByStateId = null;
		logger.debug(AppConstants.METHOD_EXE_START); 
		try {
			citiesByStateId=service.getCitiesByStateId(stateId);
			logger.info(AppConstants.CITY_DETAIS_FOUND);
		} catch (Exception e) {
			logger.error(AppConstants.EXCEPTION_STR+e.getMessage());
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED); 
		return  citiesByStateId;
	}
	
	@GetMapping(value = "/validateEmail")
	@ResponseBody
	public  String checkEmailValidate(HttpServletRequest request,Model model) {
		String email = request.getParameter("email");
		 String findByEmail = service.findByEmail(email);
		 return findByEmail;
		
	}
	
	/*
	 * @PostMapping(value = "/saveContact") public String
	 * saveContact(@ModelAttribute("contact") Contact contact,RedirectAttributes
	 * attributes) { //service.getAccountReg(contact); boolean saveContact =
	 * service.saveContact(contact); //service.getAccountReg(contact);
	 * if(saveContact) { attributes.addFlashAttribute("success",
	 * "Contact saved successfully"); //return "redirect:/userAccReg"; } else {
	 * attributes.addFlashAttribute("error", "failed to save contact"); } return
	 * "redirect:/addContact"; }
	 */
}
