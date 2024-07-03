package com.examportal.ExamPortal.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PortalUser implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String username;
private String firstName;
private String lastName;
private String confirmPassword;
private String password;
private String email;
private String phone;
private String image;
private boolean enabled=true;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="portalUser")
@JsonIgnore
private Set<UserRoles> userRole=new HashSet<>();

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Set<UserRoles> getUserRole() {
	return userRole;
}
public void setUserrolelist(Set<UserRoles> userRole) {
	this.userRole = userRole;
}

public PortalUser(Long id, String username, String firstName, String lastName, String confirmPassword, String password,
		String email, String phone, String image, boolean enabled, Set<UserRoles> userRole) {
	super();
	this.id = id;
	this.username = username;
	this.firstName = firstName;
	this.lastName = lastName;
	this.confirmPassword = confirmPassword;
	this.password = password;
	this.email = email;
	this.phone = phone;
	this.image = image;
	this.enabled = enabled;
	this.userRole = userRole;
}
public PortalUser() {
	
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	Set<Authority> set=new HashSet<>();
	this.userRole.forEach(userRole->{
		set.add(new Authority(userRole.getRole().getRoleName()));
	});
	return set;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

}
