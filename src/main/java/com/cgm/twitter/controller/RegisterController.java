package com.cgm.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.twitter.dto.ArtefactBuilder;
import com.cgm.twitter.dto.ServiceResponse;
import com.cgm.twitter.dto.User;

@RestController
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ServiceResponse register(@RequestBody User user, HttpServletRequest request) {
		System.out.println(user.getName());
		String message;
		if (ArtefactBuilder.getUsers().containsKey(user.getName())) {
			message = "UserName already taken";
		} else {

			user.setId(ArtefactBuilder.id++);
			ArtefactBuilder.addUser(user);

			message = "Registered " + user.getName() + " with id  " + user.getId();
		}
		// String session = request.getSession().getAttribute("userName").toString();
		return new ServiceResponse(message);
	}

}
