package com.item.util;

import com.item.dto.ProductRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Slf4j
@Component("RequestValidator")
@RequiredArgsConstructor
public class RequestValidator<T> {

    private final Validator validator;

    public void validate(T body) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(body);
        if (!constraintViolations.isEmpty()) {
            onValidationErrors(constraintViolations);
        }
    }

    public void brandValidate(T body){
        if(body instanceof ProductRequestDto && ((ProductRequestDto) body).getBrandId() == null){
            log.error("brand id must not null");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    private void onValidationErrors(Set<ConstraintViolation<T>> constraintViolations) {
        log.error(constraintViolations.toString());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                constraintViolations.toString());
    }
}
