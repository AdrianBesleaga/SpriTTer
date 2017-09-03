package com.cgm.twitter.controller;

import java.util.ArrayList;

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
public class FollowController {
	@RequestMapping(value = "/follow", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ServiceResponse follow(@RequestBody User user, HttpServletRequest request) {

		String message;

		String sessionUserName = request.getSession().getAttribute("userName").toString();

		if (ArtefactBuilder.friends.containsKey(sessionUserName)) {
			if (ArtefactBuilder.friends.get(sessionUserName).contains(user.getName())) {
				ArtefactBuilder.friends.get(sessionUserName).remove(user.getName());
				message = "Unfollowed ";
			} else {
				ArtefactBuilder.friends.get(sessionUserName).add(user.getName());
				message = "Followed ";
			}
		} else {
			ArrayList<String> friendList = new ArrayList<String>();
			friendList.add(user.getName());
			ArtefactBuilder.friends.put(sessionUserName, friendList);
			message = "Followed ";
		}

		return new ServiceResponse(message + user.getName());
	}
}
