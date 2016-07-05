package by.topolev.testing.bisness.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String email;
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreateUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastSignin;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setRole(Role role){
		roles.add(role);
	}
	public Date getDateCreateUser() {
		return dateCreateUser;
	}
	public void setDateCreateUser(Date dateCreateUser) {
		this.dateCreateUser = dateCreateUser;
	}
	public Date getDateLastSignin() {
		return dateLastSignin;
	}
	public void setDateLastSignin(Date dateLastSignin) {
		this.dateLastSignin = dateLastSignin;
	}
	
}
