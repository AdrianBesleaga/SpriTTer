package com.cgm.twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.dto.ArtefactBuilder;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected @ResponseBody ModelAndView home() {
		ArtefactBuilder.firstUsers();
		ArtefactBuilder.firstMessages();

		ModelAndView model;

		model = new ModelAndView("/home");
		model.addObject("messageList", ArtefactBuilder.messages);

		return model;
	}

}
