package com.cgm.spriTTer.domain;

import java.io.Serializable;

import com.cgm.spriTTer.builder.ArtefactBuilder;
import com.cgm.spriTTer.utils.SecurityUtils;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int id;
	private String name;
	private String password;

	public User() {

	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.id = ArtefactBuilder.id++;

		ArtefactBuilder.addUser(this);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = SecurityUtils.md5(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
