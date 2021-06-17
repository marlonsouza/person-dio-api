package ueh.marlon.personapidio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ueh.marlon.personapidio.dto.mapper.PersonMapper;
import ueh.marlon.personapidio.dto.request.PersonDTO;
import ueh.marlon.personapidio.dto.response.MessageResponseDTO;
import ueh.marlon.personapidio.entity.Person;
import ueh.marlon.personapidio.exception.PersonNotFoundException;
import ueh.marlon.personapidio.repository.PersonRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepository personRepository;

	private PersonMapper personMapper;
	
	public MessageResponseDTO save(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		Person saved = personRepository.save(personToSave);
		
		return createMessageResponse(saved);
	}
	
	private MessageResponseDTO createMessageResponse(Person saved) {
		return MessageResponseDTO.builder()
				.message("Person successfully created with ID " + saved.getId())
				.build();
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
					.map(personMapper::toDTO)
					.collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		
		Optional<Person> optFindById = personRepository.findById(id);
		
		return optFindById.map(personMapper::toDTO).orElseThrow(() -> new PersonNotFoundException(id));
	}

	public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		PersonDTO foundPerson = this.findById(id);
		
		Person personToSave = personMapper.toModel(foundPerson);
		
		Person saved = personRepository.save(personToSave);
		
		return createMessageResponse(saved);
	}

	public void delete(Long id) throws PersonNotFoundException {
		PersonDTO foundPerson = this.findById(id);
		
		personRepository.delete(personMapper.toModel(foundPerson));
	}
}
