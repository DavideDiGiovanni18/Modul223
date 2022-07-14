package ch.zli.m223.ksh19a.dd.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		this("");
	}

	public UserNotFoundException(String msg) {
		super(msg, null, false, false);
	}

}
