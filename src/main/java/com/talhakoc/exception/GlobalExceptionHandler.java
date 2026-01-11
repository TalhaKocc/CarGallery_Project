package com.talhakoc.exception;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(
			MethodArgumentNotValidException exception ,
			HttpServletRequest request){
		String message = exception.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(err -> err.getField() + ": " + err.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				message,
				request.getRequestURI());
		
		
		return ResponseEntity.badRequest().body(error);
	}

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException exception ,HttpServletRequest request){
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.FORBIDDEN.value(),
                "Yetkisiz Erişim: Bu işlemi yapmak için yetkiniz yok",
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(
			RuntimeException exception,
			HttpServletRequest request) {
		
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.badRequest().body(error);
	}
}
