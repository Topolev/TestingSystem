package by.topolev.testing.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SigninController {
	@RequestMapping(value="/sigin", method = RequestMethod.GET)
	public String showFormSigin(){
		return "authuser/signin";
	}
}
