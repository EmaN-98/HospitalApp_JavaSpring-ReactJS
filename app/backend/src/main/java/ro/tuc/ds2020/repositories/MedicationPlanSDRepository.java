package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.MedicationPlanSD;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicationPlanSDRepository extends JpaRepository<MedicationPlanSD, UUID> {
/*
    
  ///  List<MedicationPlanSD> findByName(String name);

    
    @Query(value = "SELECT p " +
            "FROM MedicationPlanSD p " +
            "WHERE p.name = :name " +
            "AND p.age >= 60  ")
    Optional<MedicationPlanSD> findSeniorsByName(@Param("name") String name);
*/
}
