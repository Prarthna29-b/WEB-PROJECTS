package com.examportal.ExamPortal.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long roleId;
private String roleName;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="role")
private Set<UserRoles> userRole=new HashSet<>();
public Long getRoleId() {
	return roleId;
}
public void setRoleId(Long roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public Set<UserRoles> getUserRole() {
	return userRole;
}
public void setUserRole(Set<UserRoles> userRole) {
	this.userRole = userRole;
}
public Role() {
	
}
public Role(Long roleId, String roleName) {
	
	this.roleId = roleId;
	this.roleName = roleName;
}

}
