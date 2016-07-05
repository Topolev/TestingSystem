package by.topolev.testing.bisness.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.topolev.testing.bisness.entity.Role;
@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role,Long> implements RoleDao {

	RoleDaoImpl(){
		this(Role.class);
	}
	RoleDaoImpl(Class<Role> type) {
		super(type);
	}
	@Override
	public Role findByRole(String nameRole) {
		TypedQuery<Role> query = em.createQuery("select r from Role r where r.role=:role", Role.class).setParameter("role", nameRole);
		Role role = query.getSingleResult();
		return role;
	}

}
