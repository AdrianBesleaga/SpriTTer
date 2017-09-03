package com.cgm.twitter.dto;

import java.io.Serializable;
import java.util.Collections;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private String text;
	private String user;
	private String date;

	public Message() {}

	public Message(String text, String user, String time) {
		super();
		this.text = text;
		this.user = user;
		this.date = time;
		ArtefactBuilder.addMessage(user, this);
		Collections.reverse(ArtefactBuilder.messages.get(user));
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	
}
