package com.example.taskflow.exception;


import com.example.taskflow.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(
                        error.getField(),
                        error.getDefaultMessage()
                ));

        ErrorResponse response = new ErrorResponse("Błąd walidacji", errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatus(ResponseStatusException ex) {
        Map<String, String> errors = Map.of("detail", ex.getReason() != null ? ex.getReason() : "Nie znaleziono zasobu");
        ErrorResponse response = new ErrorResponse(ex.getReason() != null ? ex.getReason() : "Zasób nie istnieje", errors);
        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        Map<String, String> errors = Map.of("error", ex.getMessage() != null ? ex.getMessage() : "Wystąpił błąd");
        ErrorResponse response = new ErrorResponse("Błąd serwera", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex) {
        Map<String, String> errors = Map.of("error", "Brak wymaganych uprawnień (np. roli ADMIN)");
        ErrorResponse response = new ErrorResponse("Odmowa dostępu", errors);

        // Zwracamy poprawny status: 403 FORBIDDEN
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}