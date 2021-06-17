package ueh.marlon.personapidio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static ueh.marlon.personapidio.utils.PersonUtils.createFakeDTO;
import static ueh.marlon.personapidio.utils.PersonUtils.createFakeEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ueh.marlon.personapidio.dto.mapper.PersonMapper;
import ueh.marlon.personapidio.dto.request.PersonDTO;
import ueh.marlon.personapidio.dto.response.MessageResponseDTO;
import ueh.marlon.personapidio.entity.Person;
import ueh.marlon.personapidio.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@Mock
    private PersonMapper personMapper;
	
	@InjectMocks
	private PersonService personService;

	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		
		PersonDTO personDTO = createFakeDTO();
		Person expectPersonEntity = createFakeEntity();
		
		when(personMapper.toModel(personDTO)).thenReturn(expectPersonEntity);
		when(personRepository.save(any(Person.class))).thenReturn(expectPersonEntity);
		
		MessageResponseDTO expectedMessageDTO = createExpectedMessageDTO(expectPersonEntity.getId());
		
		MessageResponseDTO successMessage = personService.save(personDTO);
		
		assertEquals(expectedMessageDTO.getMessage(), successMessage.getMessage());
		
	}

	private MessageResponseDTO createExpectedMessageDTO(Long id) {
		return MessageResponseDTO
				.builder()
				.message("Person successfully created with ID " + id)
				.build();
	}
	
}
