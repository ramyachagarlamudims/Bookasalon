package com.bookasalon.org.Repository;
import com.bookasalon.org.Model.UserData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {

  @Query(value = "select * from userdata u where u.email = (:email) and u.password = (:password)", nativeQuery = true)
  public UserData findbyusername(@Param("email") String email, @Param("password") String password);

  @Modifying
  @Query(value = "insert into userdata (username,email,password) values (:userName, :email, :password)", nativeQuery = true)
  @Transactional
  public void saveUser(@Param("userName") String userName, @Param("email") String email, @Param("password") String password);
}
