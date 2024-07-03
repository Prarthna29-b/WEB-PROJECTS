package com.examportal.ExamPortal.models;

public class JwtRequest {
String username;
String password;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public JwtRequest(String email, String password) {
	super();
	this.username = email;
	this.password = password;
}
public JwtRequest() {
	super();
	// TODO Auto-generated constructor stub
}

}
