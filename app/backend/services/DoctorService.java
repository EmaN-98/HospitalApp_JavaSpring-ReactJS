package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.DoctorDetailsDTO;
import ro.tuc.ds2020.dtos.builders.DoctorBuilder;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.DoctorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> findDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream()
                .map(DoctorBuilder::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public DoctorDetailsDTO findDoctorById(UUID id) {
        Optional<Doctor> prosumerOptional = doctorRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Doctor with id {} was not found in db", id);
            throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with id: " + id);
        }
        return DoctorBuilder.toDoctorDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(DoctorDetailsDTO doctorDTO) {
    	Doctor doctor = DoctorBuilder.toEntity(doctorDTO);
    	doctor =doctorRepository.save(doctor);
        LOGGER.debug("Doctor with id {} was inserted in db", doctor.getId());
        return doctor.getId();
    }

    public void deleteById(UUID id) {
   	 Optional<Doctor> prosumerOptional = doctorRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Doctor with id {} was not found in db", id);
            throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with id: " + id);
        }else {
       	 doctorRepository.deleteById(id);
        }
   }
   
   public void deleteByName(String name) {
  	 Doctor prosumerOptional = doctorRepository.findByName(name);
       if (prosumerOptional==null) {
           LOGGER.error("Doctor with name {} was not found in db", name);
           throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with name: " + name);
       }else {
       	doctorRepository.delete(prosumerOptional);
       }
  }
   
   
   public void update(UUID id,String name,List<Patient> patients,String role) {
  	 Optional<Doctor> prosumerOptional = doctorRepository.findById(id);
       if (!prosumerOptional.isPresent()) {
           LOGGER.error("Doctor with id {} was not found in db", id);
           throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with id: " + id);
       }else {
       //	doctorRepository.update(id,name,birthday,gender,address,patients);
       	Doctor c=doctorRepository.findByName(name);
       	c.setName(name);
       	c.setPatients(patients);
       	c.setRole(role);
       	c=doctorRepository.save(c); System.out.println("Doctor "+ name+" was updated");
       }
  }
   
   public Doctor findByName(String name){
       return doctorRepository.findByName(name);
   }
   
   public boolean checkExistsByUsername(String username) {
   	return doctorRepository.existsByName(username);
   }
}
