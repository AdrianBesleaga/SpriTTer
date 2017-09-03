package com.cgm.twitter.dto;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ArtefactBuilder {
	public static int id = 0;
	public static Map<String, ArrayList<String>> friends = new HashMap<String, ArrayList<String>>();
	public static Map<String, User> users = new HashMap<String, User>();
	public static Map<String, ArrayList<Message>> messages = new HashMap<String, ArrayList<Message>>();

	public static void firstUsers() {
		if (users.isEmpty()) {
			new User("adrian", ArtefactBuilder.md5("123"));
			new User("alex", ArtefactBuilder.md5("123"));
			new User("daniel", ArtefactBuilder.md5("123"));
		}
	}

	public static void firstMessages() {
		if (messages.isEmpty()) {
			new Message("Hello SpriTTer !!!", "adrian", currentTime());
			new Message("Hello Again !!!", "adrian", currentTime());
			new Message("What a beautiful day !", "daniel", currentTime());
		}
	}
	
	public static String currentTime() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return(sdf.format(new Date()));
	}

	public static void addUser(User user) {
		users.put(user.getName(), user);
	}

	public static void addMessage(String user, Message message) {
		if (messages.containsKey(user)) {
			messages.get(user).add(message);
		} else {
			ArrayList<Message> listMes = new ArrayList<Message>();
			listMes.add(message);
			messages.put(user, listMes);
		}
	}

	public static String md5(String input) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(input.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				sb.append(String.format("%02x", array[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return null;
		}

	}

	public static Map<String, User> getUsers() {
		return users;
	}

	public static Map<String, ArrayList<Message>> getMessages() {
		return messages;
	}


}
