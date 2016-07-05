package by.topolev.testing.bisness.convertors;

import org.springframework.stereotype.Component;

import by.topolev.testing.bisness.entity.User;
import by.topolev.testing.web.formdata.UserRegisterForm;
@Component("userRegisterFormConvertor")
public class UserRegisterFormConvertor implements Convertor<User, UserRegisterForm> {

	@Override
	public User createBisnessClassFromFormData(UserRegisterForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		return user;
	}

}
