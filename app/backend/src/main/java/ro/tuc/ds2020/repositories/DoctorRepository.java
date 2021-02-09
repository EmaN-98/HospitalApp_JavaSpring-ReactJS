package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    Doctor findByName(String name);
    
    Boolean existsByName(String username);
	
  	//Boolean existsByPassword(String password);
     
    /**
     * Example: Write Custom Query
     */
	/*@Query(value = "SELECT u " +
            "FROM doctor u " +
            "WHERE u.name = :name ")
    List<Doctor> findByName(@Param("name") String name);*/
}
