package edu.pune.university.data;

import org.bson.Document;

public class UserData extends Document {
	private static final long serialVersionUID = 1L;
	private String userName = "userName";
	private String password = "password";

	public String getUserName() {
		return (String) this.get(this.userName);
	}

	public void setUserName(String userName) {
		this.append(this.userName, userName);
	}

	public String getPassword() {
		return (String) this.get(this.password);
	}

	public void setPassword(String password) {
		this.append(this.password, password);
	}

}
