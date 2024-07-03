package com.examportal.ExamPortal.models;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
private String authority;
	public Authority(String authority) {
	
	this.authority = authority;
}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority ;
	}

}
