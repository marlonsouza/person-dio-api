package ueh.marlon.personapidio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ueh.marlon.personapidio.dto.mapper.PersonMapper;
import ueh.marlon.personapidio.dto.request.PersonDTO;
import ueh.marlon.personapidio.dto.response.MessageResponseDTO;
import ueh.marlon.personapidio.entity.Person;
import ueh.marlon.personapidio.repository.PersonRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepository personRepository;

	private PersonMapper personMapper;
	public MessageResponseDTO save(PersonDTO personDTO) {
		Person model = personMapper.toModel(personDTO);
		Person saved = personRepository.save(model);
		
		return createMessageResponse(saved);
	}
	
	private MessageResponseDTO createMessageResponse(Person saved) {
		return MessageResponseDTO.builder()
				.message("Person successfully created with ID " + saved.getId())
				.build();
	}
	
}
