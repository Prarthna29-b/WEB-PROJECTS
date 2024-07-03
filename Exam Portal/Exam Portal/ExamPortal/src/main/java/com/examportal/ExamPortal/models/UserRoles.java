package com.examportal.ExamPortal.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserRoles {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long userRoleId;
@ManyToOne(fetch=FetchType.EAGER)
private PortalUser portalUser;
@ManyToOne(fetch=FetchType.EAGER)
private Role role;
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Long getUserRoleId() {
	return userRoleId;
}
public void setUserRoleId(Long userRoleId) {
	this.userRoleId = userRoleId;
}
public PortalUser getUser() {
	return portalUser;
}
public void setUser(PortalUser portalUser) {
	this.portalUser = portalUser;
}
public UserRoles() {
	
}

}
