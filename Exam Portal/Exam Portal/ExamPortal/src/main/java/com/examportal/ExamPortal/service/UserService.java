package com.examportal.ExamPortal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.ExamPortal.models.PortalUser;
import com.examportal.ExamPortal.models.UserRoles;
import com.examportal.ExamPortal.repo.UserRepository;
import com.examportal.ExamPortal.repo.RoleRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private RoleRepository rolerepo;

	public PortalUser create(PortalUser portalUser,Set<UserRoles> userrole ) throws Exception
	{
		PortalUser local =userrepo.findByUsername(portalUser.getUsername());
		if(local!=null)
		{
			System.out.println("User is already exist !!");
			throw new Exception("user is already present !!");	
		}
		else
		{
			for(UserRoles r:userrole)
				rolerepo.save(r.getRole());
		}
	portalUser.getUserRole().addAll(userrole);
	local=userrepo.save(portalUser);
		return local;
	}
	public PortalUser get(String username)
	{
		return userrepo.findByUsername(username);
	}
	public void delete(Long id) {
		
		userrepo.deleteById(id);
	}

	public void save(PortalUser portalUser) {

			userrepo.save(portalUser);
		}
	public List<PortalUser> listAll() {
		return userrepo.findAll();
	}
	}


