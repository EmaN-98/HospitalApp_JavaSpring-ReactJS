package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaregiverRepository extends JpaRepository<Caregiver, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    Caregiver findByName(String name);

	

	Boolean existsByName(String username);
	
	//Boolean existsByPassword(String password);
    /**
     * Example: Write Custom Query
     */
	/*@Query(value = "SELECT u " +
            "FROM caregiver u " +
            "WHERE u.name = :name ")
    List<Caregiver> findByName(@Param("name") String name);*/
    
	/*@Query(value="UPDATE caregiver c " +
			"SET c.name = :name , " +
			"c.birthday = :birthday , " +
			"c.gender = :gender , " +
			"c.address = :address , " +
			"c.patients = :patients " +
			"WHERE c.id = :id ")
	void update(@Param("id") UUID id,@Param("name") String name,@Param("birthday") String birthday,@Param("gender") String gender,@Param("address") String address,@Param("patients") List<Patient> patients);
*/
}
