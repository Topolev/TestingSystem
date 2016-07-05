package by.topolev.testing.bisness.service;

import by.topolev.testing.bisness.entity.User;

public interface UserService {
	public void createNewUser(User user, String nameRole);
	public User getUserByUsernameOrEmail(String usernameOrEmail);
}
