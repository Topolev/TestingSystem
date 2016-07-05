package by.topolev.testing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.topolev.testing.bisness.fasads.AuthorizationUserFasadImpl;
import by.topolev.testing.web.formdata.UserRegisterForm;
@Controller
public class SigninController {
	@Autowired
	private AuthorizationUserFasadImpl authFasad;
	
	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String showFormSigin(){
		return "authuser/signin";
	}
	@RequestMapping(value="/signin-fail", method=RequestMethod.GET)
	public String siginFail(Model model){
		model.addAttribute("error", true);
		return "authuser/signin";
	}
	
	@RequestMapping(value="/signin-success", method=RequestMethod.GET)
	public String authSuccess(Model model){
		model.addAttribute("error", true);
		return "/index";
	}
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String showRegisterForm(){
		return "authuser/register";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("userRegisterForm") UserRegisterForm form){
		authFasad.createNewUser(form);
		return "/index";
	}
}
