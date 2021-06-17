package ueh.marlon.personapidio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ueh.marlon.personapidio.dto.request.PersonDTO;
import ueh.marlon.personapidio.dto.response.MessageResponseDTO;
import ueh.marlon.personapidio.exception.PersonNotFoundException;
import ueh.marlon.personapidio.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@Valid @RequestBody PersonDTO person) {
		return personService.save(person);
	}
	
	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
		return personService.update(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) throws PersonNotFoundException {
		personService.delete(id);
	}
}
