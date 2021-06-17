package ueh.marlon.personapidio.utils;

import java.time.LocalDate;
import java.util.Collections;

import ueh.marlon.personapidio.dto.request.PersonDTO;
import ueh.marlon.personapidio.entity.Person;

public class PersonUtils {

	private static final String FISRT_NAME = "Marlon";
	private static final String LAST_NAME = "Souza";
	private static final String CPF_NUMBER = "446.885.800-10";
	private static final Long PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(1988, 04, 27);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FISRT_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate("27-04-1988")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FISRT_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}
	
}
