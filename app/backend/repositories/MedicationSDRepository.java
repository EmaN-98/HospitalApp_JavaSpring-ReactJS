package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.MedicationSD;
import ro.tuc.ds2020.entities.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicationSDRepository extends JpaRepository<MedicationSD, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
   MedicationSD findByName(String name);

    /**
     * Example: Write Custom Query
     */
	/*@Query(value = "SELECT u " +
            "FROM medicationsd u " +
            "WHERE u.name = :name ")
    List<MedicationSD> findByName(@Param("name") String name);*/

}
