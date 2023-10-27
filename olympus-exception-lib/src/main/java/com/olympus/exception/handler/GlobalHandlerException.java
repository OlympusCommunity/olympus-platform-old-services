package com.olympus.exception.handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.olympus.exception.emun.ExceptionEnum;
import com.olympus.exception.dto.ExceptionDetailDTO;
import com.olympus.exception.util.Constantes;
import com.olympus.exception.resource.CreatedException;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.NoContentException;
import com.olympus.exception.resource.ResourceBadRequestException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.exception.resource.ValidationException;


@ControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<?> resourceNotFoundException(
			  ResourceNotFoundException ex, WebRequest request) {
	    ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.NOT_FOUND.getHttpStatus(),
	            Constantes.NOT_FOUND,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(ValidationException.class)
	  public ResponseEntity<?> validationException(ValidationException ex, WebRequest request) {
		  ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.OK.getHttpStatus(),
	        	Constantes.OK,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.OK);
	  }
	  
	  @ExceptionHandler(CreatedException.class)
	  public ResponseEntity<?> createdException(CreatedException ex, WebRequest request) {
		  ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.CREATED.getHttpStatus(),
	        	Constantes.CREATED,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.CREATED);
	  }
	  
	  @ExceptionHandler(NoContentException.class)
	  public ResponseEntity<?> noContentException(NoContentException ex, WebRequest request) {
		  ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.CREATED.getHttpStatus(),
	        	Constantes.CREATED,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.NO_CONTENT);
	  }

	  @ExceptionHandler(ResourceConflictException.class)
	  public ResponseEntity<?> resoruceConflictException(
			  ResourceConflictException ex, WebRequest request) {
		  ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.CONFLICT.getHttpStatus(),
	            Constantes.CONFLICT,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.CONFLICT);
	  }

	  @ExceptionHandler(InternalServerErrorException.class)
	  public ResponseEntity<?> internalServerErrorException(
			  InternalServerErrorException ex, WebRequest request) {
		  ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.INTERNAL_SERVER_ERROR.getHttpStatus(),
	            Constantes.INTERNAL_SERVER_ERROR,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	  @ExceptionHandler(ResourceBadRequestException.class)
	  public ResponseEntity<?> badRequestException(ResourceBadRequestException ex, WebRequest request) {
		  ExceptionDetailDTO exceptionDetail =
	        new ExceptionDetailDTO(
	        	ExceptionEnum.BAD_REQUEST.getHttpStatus(),
	        	Constantes.BAD_REQUEST,
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false),
	            String.valueOf(ex.getStackTrace()));
	    return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	  }

}
