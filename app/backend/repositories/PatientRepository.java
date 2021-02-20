package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    Patient findByName(String name);

    Boolean existsByName(String username);
	
  	//Boolean existsByPassword(String password);
     
    /**
     * Example: Write Custom Query
     */
	/*@Query(value = "SELECT u " +
            "FROM patient u " +
            "WHERE u.name = :name ")
    List<Patient> findByName(@Param("name") String name);*/

    @Query(value = "SELECT p FROM Patient p WHERE p.caregiverName = :name")
    List<Patient> getPatientsForCaregiver(@Param("name")String name);
}
