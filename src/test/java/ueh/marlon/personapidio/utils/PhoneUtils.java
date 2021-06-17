package ueh.marlon.personapidio.utils;

import ueh.marlon.personapidio.dto.request.PhoneDTO;
import ueh.marlon.personapidio.entity.Phone;
import ueh.marlon.personapidio.enums.PhoneType;

public class PhoneUtils {

	private static final String PHONE_NUMBER = "48999998888";
	private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
	private static final Long PHONE_ID = 1L;
	
	public static PhoneDTO createFakeDTO() {
		return PhoneDTO.builder()
				.number(PHONE_NUMBER)
				.type(PHONE_TYPE)
				.build();
	}
	
	public static Phone createFakeEntity() {
		return Phone.builder()
				.id(PHONE_ID)
				.number(PHONE_NUMBER)
				.type(PHONE_TYPE)
				.build();
	}
	
}
