package edu.uncc.ssdi.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uncc.ssdi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
	UserService userservice;
	@RequestMapping(value="/validateLogin/", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody
    User loginProcess(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam String email , @RequestParam String password) {
		//System.out.println("Reached here");
		// Login using a User's credentials matching a current user in the database
		Login login = new Login();
		login.setUserName(email);
		login.setPassword(password);
		//System.out.println(login.getUserName());
		//System.out.println(login.getPassword());
		User user = userservice.validateUser(login);
		return user;
	}
} // end of class