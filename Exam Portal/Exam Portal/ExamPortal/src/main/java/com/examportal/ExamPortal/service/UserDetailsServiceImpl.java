package com.examportal.ExamPortal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examportal.ExamPortal.models.PortalUser;
import com.examportal.ExamPortal.repo.UserRepository;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PortalUser portalUser= userRepository.findByUsername( username);
		if(portalUser==null)
			throw new UsernameNotFoundException("User with this credintial not found!!");
		else
		return portalUser;
	}
	

}
