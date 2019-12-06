
package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "signup")
public class validatepojo {
	@Id
	private String username;
	
	private String firstname;
	private String lastname;
	
	private String emailid;
	private String password;
	private boolean admin;
	

	@Override
	public String toString() {
		return "validatepojo [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", emailid=" + emailid + ", password=" + password + "]";
	}

	public validatepojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public validatepojo(String username, String firstname, String lastname, String emailid, String password,
			boolean admin) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.admin = admin;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	

} 
 
