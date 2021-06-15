package ueh.marlon.personapidio.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ueh.marlon.personapidio.dto.request.PersonDTO;
import ueh.marlon.personapidio.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mapping(target = "birthDate", source = "birthDate", dateFormat =  "dd-MM-yyyy")
	Person toModel(PersonDTO dto);
	
	PersonDTO toDTO(Person entity);
	
}
