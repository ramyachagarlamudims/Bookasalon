package com.bookasalon.org.Repository;
import com.bookasalon.org.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query(value = "select * from user u where u.email = (:email) and u.password = (:password)", nativeQuery = true)
  public User findbyusername(@Param("email") String email, @Param("password") String password);

  @Modifying
  @Query(value = "insert into user (user,email,password) values (:user, :email, :password)", nativeQuery = true)
  @Transactional
  public void saveUser(@Param("user") String user, @Param("email") String email, @Param("password") String password);
}
