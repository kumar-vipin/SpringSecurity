/**
 * 
 */
package com.vipin.user.dao;

import com.vipin.model.User;

/**
 * @author VIPIN
 *
 */
public interface UserDao {
	User findUserByName(String username);
}
