package by.topolev.testing.bisness.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.topolev.testing.bisness.entity.Role;
import by.topolev.testing.bisness.entity.User;
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserService userService;

	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userService.getUserByUsernameOrEmail(usernameOrEmail);
		Set<GrantedAuthority> roles = getGrantedAuthorityByString(user);
		
		LOGGER.info(String.format("Sigin user with name %s with next roles:", user.getUsername()));
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
                user.getPassword(), 
                roles);
		return userDetails;
	}
	
	public static Set<GrantedAuthority> getGrantedAuthorityByString(User user){
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for(Role role : user.getRoles()){
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return roles;
	}

}
