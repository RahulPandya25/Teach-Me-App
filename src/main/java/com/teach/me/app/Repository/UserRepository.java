/**
 * 
 */
package com.teach.me.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teach.me.app.Model.User;

/**
 * @author Aayushee Dave
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
