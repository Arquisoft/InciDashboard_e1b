package com.e1b.services;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.e1b.entities.Operario;
import com.e1b.repositories.OperariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Autowired
    private OperariosRepository operariosRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	    Operario o = operariosRepository.findByUsername(username);
	    
	    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	  
	    return  new org.springframework.security.core.userdetails.User(
	            o.getUsername(), o.getPassword(), grantedAuthorities);
	}
	
}
