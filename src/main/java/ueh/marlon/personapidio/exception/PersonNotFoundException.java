package ueh.marlon.personapidio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersonNotFoundException(Long id) {
		super(String.format("Person with ID %s not found", id));
	}

}
