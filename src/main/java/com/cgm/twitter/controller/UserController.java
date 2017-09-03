package com.cgm.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.dto.ArtefactBuilder;
import com.cgm.twitter.dto.ServiceResponse;
import com.cgm.twitter.dto.User;

@RestController
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	protected ModelAndView getUserPage() throws Exception {

		ModelAndView model;

		model = new ModelAndView("redirect:/users");

		return model;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	protected ModelAndView getUsers() throws Exception {

		ModelAndView model;

		model = new ModelAndView("users", "usersList", ArtefactBuilder.users);

		return model;
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	protected ModelAndView getUser(@PathVariable String name, HttpServletRequest request) throws Exception {
		System.out.println(name);
		ModelAndView model;

		if (ArtefactBuilder.users.containsKey(name)) {
			User user = ArtefactBuilder.users.get(name);
			model = new ModelAndView("user", "userNameText", user.getName());
			model.addObject("userId", user.getId());
			model.addObject("userPassword", user.getPassword());
			model.addObject("userMessages", ArtefactBuilder.messages.get(name));
			model.addObject("userFriends", ArtefactBuilder.friends.get(name));
			String sessionUserName = request.getSession().getAttribute("userName").toString();
			if (ArtefactBuilder.friends.containsKey(sessionUserName)
					&& ArtefactBuilder.friends.get(sessionUserName).contains(name)) {
				model.addObject("followButton", "UnFollow");
			} else {
				model.addObject("followButton", "Follow");
			}
		} else {
			model = new ModelAndView("user", "userNameText", null);
		}
		return model;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ServiceResponse createArtist(@RequestBody User user) {
		System.out.println(user.getName());
		return new ServiceResponse(user.getName());
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ServiceResponse updateArtist(User user) {
		System.out.println("Called update Artist service!" + user.getName());
		return new ServiceResponse(user.getName());
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ServiceResponse deleteArtist(@RequestHeader("token") String token, @PathVariable Long id) {
		System.out.println("Called delete Artist (" + id + ") service with token: " + token + " !");
		return new ServiceResponse("deleted : " + id);
	}

}