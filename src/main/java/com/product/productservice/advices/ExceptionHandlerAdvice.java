package com.product.productservice.advices;


import com.product.productservice.dtos.ArithmeticExceptionDto;
import com.product.productservice.dtos.ArrayIndexOutOfBoundExceptionDto;
import com.product.productservice.dtos.ExceptionDto;
import com.product.productservice.exception.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException() {
        ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setDetail("Some random detail");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleAIOBException() {
        return null;
    }

    //@ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> handleInvalidProductIdException(InvalidProductIdException exception) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setProductId(exception.getProductId());
        exceptionDto.setMessage("Invalid productId passed, please retry with a valid productId");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
