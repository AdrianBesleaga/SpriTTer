package com.cgm.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.twitter.dto.ArtefactBuilder;
import com.cgm.twitter.dto.Message;
import com.cgm.twitter.dto.ServiceResponse;

@RestController
public class MessageController {
	@RequestMapping(value = "/message", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody ServiceResponse message(@RequestBody Message message, HttpServletRequest request) {

		if (message.getText().length() > 3) {
			new Message(message.getText(), request.getSession().getAttribute("userName").toString(),
					ArtefactBuilder.currentTime());
		} else {
			return new ServiceResponse("Post a longer message ! ");
		}

		return new ServiceResponse("Message posted : " + message.getText());
	}
}
