package com.cg.kyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.kyc.dto.Wallet;
import com.cg.kyc.service.Iwalletservice;

@Controller
public class MyController {
	@Autowired
	Iwalletservice walSer;
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String all()
	{
		return "home";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addCustomer(@ModelAttribute("my") Wallet wallet){
		return "addCustomer";
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertCustomer(@ModelAttribute("my") Wallet wallet){
		walSer.createAccount(wallet);
		return new ModelAndView("added");
	}
	
	@RequestMapping(value="show",method=RequestMethod.GET)
	public ModelAndView showCustDetails(){
		List<Wallet> custDetails = walSer.showAccount(); 
		return new ModelAndView("showall","temp",custDetails);
			}
	
	@RequestMapping(value="deposit",method=RequestMethod.GET)
	public String depositAmt(@ModelAttribute("my") Wallet wallet){
		
		//wallet.setMobNo(wallet.getMobNo());
		
	return "depAmt";
			
	}
	
	@RequestMapping(value="deposit_money",method=RequestMethod.POST)
	public ModelAndView(@RequestParam("mobno") String mobNo,@RequestParam("depAmt") double amount,@ModelAttribute("my") Wallet wallet){
		walSer.depositAmt(mobNo,amount);
		return new ModelAndView();
	}
	
	
}
