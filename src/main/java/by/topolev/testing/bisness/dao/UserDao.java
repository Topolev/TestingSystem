package by.topolev.testing.bisness.dao;

import java.util.List;

import by.topolev.testing.bisness.entity.User;

public interface UserDao extends GenericDao <User, Long>{
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User findByUsernameOrEmail(String usernameOrEmail);
	public List<User> findUsersNotSigninMore(long ms);
}
