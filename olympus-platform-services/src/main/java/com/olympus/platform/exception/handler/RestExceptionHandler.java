package com.olympus.platform.exception.handler;

import com.olympus.platform.exception.ErrorDetailDTO;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    String error = "Malformed JSON request";
    return buildResponseEntity(new ErrorDetailDTO(HttpStatus.BAD_REQUEST, error, ex));
  }

  private ResponseEntity<Object> buildResponseEntity(ErrorDetailDTO apiError) {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
    ErrorDetailDTO apiError = new ErrorDetailDTO(HttpStatus.NOT_FOUND);
    apiError.setMessage(ex.getMessage());
    return buildResponseEntity(apiError);
  }

  @ExceptionHandler(OlympusBusinessException.class)
  protected ResponseEntity<Object> handleOlympusBusiness(OlympusBusinessException ex) {
    ErrorDetailDTO apiError = new ErrorDetailDTO(HttpStatus.INTERNAL_SERVER_ERROR);
    apiError.setMessage(ex.getMessage());
    return buildResponseEntity(apiError);
  }

  @ExceptionHandler(ResourceConflictsException.class)
  protected ResponseEntity<Object> handleResourceConflicts(ResourceConflictsException ex) {
    ErrorDetailDTO apiError = new ErrorDetailDTO(HttpStatus.CONFLICT);
    apiError.setMessage(ex.getMessage());
    return buildResponseEntity(apiError);
  }

  @ExceptionHandler(ResourceValidationException.class)
  protected ResponseEntity<Object> handleResourceValidation(ResourceValidationException ex) {
    ErrorDetailDTO apiError = new ErrorDetailDTO(HttpStatus.BAD_REQUEST);
    apiError.setMessage(ex.getMessage());
    return buildResponseEntity(apiError);
  }
}
