/**
 * 
 */
package com.vipin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author VIPIN
 *
 */
@Entity
@Table(name = "Role")
public class Role implements GrantedAuthority, Serializable {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "rolename")
	@Enumerated(EnumType.STRING)
	private RoleType roleName;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {
	}

	public Role(final RoleType roleName) {
		this.roleName = roleName;
	}

	public Role(int id, RoleType roleName, List<User> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleType getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleType roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return roleName.toString();
	}

	@Override
	public boolean equals(Object obj) {
		String name = roleName.toString();
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		String otherRoleName = other.getRoleName().toString();
		if (roleName == null) {
			if (otherRoleName != null)
				return false;
		} else if (!name.equalsIgnoreCase(otherRoleName))
			return false;
		return true;
	}

}
