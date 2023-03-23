package com.olufunmi.drone.exceptions;

import com.olufunmi.drone.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DroneException.class)
    public ResponseEntity<?> handleDroneException(DroneException droneException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(droneException.getMessage())
                .statusCode(400)
                .successful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
