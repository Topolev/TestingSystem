package by.topolev.testing.bisness.fasads;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import by.topolev.testing.bisness.convertors.UserRegisterFormConvertor;
import by.topolev.testing.bisness.entity.User;
import by.topolev.testing.bisness.service.UserService;
import by.topolev.testing.web.formdata.UserRegisterForm;
@Component
public class AuthorizationUserFasadImpl implements AuthorizationUserFasad{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AuthorizationUserFasadImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDeailsService;
	
	@Resource(name="userRegisterFormConvertor")
	private UserRegisterFormConvertor convertor;
	
	
	@Override
	public void createNewUser(UserRegisterForm form){
		User user = convertor.createBisnessClassFromFormData(form);
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userService.createNewUser(user, "ROLE_USER");
		
		/*Authenntication user after registration*/
		UserDetails userDetails = userDeailsService.loadUserByUsername(user.getUsername());
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				userDetails,
				user.getPassword(),
				userDetails.getAuthorities()
				);
		
		LOGGER.info(String.format("Create new user with username = %s", userDetails.getUsername()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
