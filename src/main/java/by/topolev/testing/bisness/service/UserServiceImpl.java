package by.topolev.testing.bisness.service;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.topolev.testing.bisness.dao.RoleDao;
import by.topolev.testing.bisness.dao.UserDao;
import by.topolev.testing.bisness.entity.Role;
import by.topolev.testing.bisness.entity.User;
@Service
public  class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void createNewUser(User user, String nameRole) {
		user.setPassword(user.getPassword());
		user.setDateCreateUser(new Date());
		user.setDateLastSignin(new Date());
		Role role = roleDao.findByRole(nameRole);
		user.setRole(role);
		userDao.create(user);
	}

	@Override
	public User getUserByUsernameOrEmail(String usernameOrEmail) {
		return userDao.findByUsername(usernameOrEmail);
	}

}
