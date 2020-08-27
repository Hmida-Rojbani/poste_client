package tn.poste.client.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientErrorHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
	    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }
	
	@ExceptionHandler(ClientNotFoundException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleClientNotFoundException(ClientNotFoundException e) {
	    return new ResponseEntity<>("Client Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }


}
