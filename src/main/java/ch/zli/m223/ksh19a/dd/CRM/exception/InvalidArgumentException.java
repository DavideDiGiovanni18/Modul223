package ch.zli.m223.ksh19a.dd.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException() {
		this("");
	}

	public InvalidArgumentException(String msg) {
		super(msg, null, false, false);
	}

}
