package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.UserSD;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSDRepository extends JpaRepository<UserSD, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    UserSD findByUsername(String username);

  	Boolean existsByPassword(String password);
    /**
     * Example: Write Custom Query
     */
   /* @Query(value = "SELECT u " +
            "FROM userSD u " +
            "WHERE u.username = :username ")
    List<UserSD> findByUserame(@Param("username") String username);*/

}
