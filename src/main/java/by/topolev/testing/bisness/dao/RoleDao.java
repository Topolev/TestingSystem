package by.topolev.testing.bisness.dao;

import by.topolev.testing.bisness.entity.Role;

public interface RoleDao extends GenericDao<Role, Long>{
	Role findByRole(String role);
}
