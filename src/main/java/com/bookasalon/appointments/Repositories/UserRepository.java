package com.bookasalon.appointments.Repositories;

        import com.bookasalon.appointments.Models.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query(value = "select * from user u where u.email = (:email) and u.password = (:password)", nativeQuery = true)
  public User findbyemail(@Param("email") String email, @Param("password") String password);
    User findByEmail(String email);

}
