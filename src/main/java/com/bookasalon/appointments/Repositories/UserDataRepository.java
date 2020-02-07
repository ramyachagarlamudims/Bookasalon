package com.bookasalon.appointments.Repositories;

        import com.bookasalon.appointments.Models.UserData;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserDataRepository extends JpaRepository<UserData, Integer> {

  @Query(value = "select * from userdata u where u.email = (:email) and u.password = (:password)", nativeQuery = true)
  public UserData findbyemail(@Param("email") String email, @Param("password") String password);
    UserData findByEmail(String email);

}
