package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDetailsDTO;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.UserSD;

public class UserSDBuilder {

    private UserSDBuilder() {
    }

    public static UserSDDTO toUserSDDTO(UserSD userSD) {
        return new UserSDDTO(userSD.getId(), userSD.getUsername(), userSD.getRole());
    }

    public static UserSDDetailsDTO toUserSDDetailsDTO(UserSD userSD) {
        return new UserSDDetailsDTO(userSD.getId(), userSD.getUsername(), userSD.getPassword(), userSD.getRole());
    }

    public static UserSD toEntity(UserSDDetailsDTO userSDDetailsDTO) {
        return new UserSD(userSDDetailsDTO.getUsername(),
        		userSDDetailsDTO.getPassword(),
        		userSDDetailsDTO.getRole());
    }
}
