package com.salesianostriana.viviendafilter.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.jspecify.annotations.Nullable;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIlegalArgumentException(IllegalArgumentException ex) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        pd.setTitle("Argumento erróneo");
        return pd;
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Error de validación");

        List<ApiValidationSubError> errorList = ex.getAllErrors().stream().map(ApiValidationSubError::from).toList();
        pb.setProperty("invalid-params", errorList);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pb);

    }

    @Builder
    record ApiValidationSubError(
            String object,
            String message,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            String field,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            String rejectValue
    ) {

        public ApiValidationSubError(String object, String message) {
            this(object, message, null, null);
        }

        public static ApiValidationSubError from(ObjectError objectError) {

            ApiValidationSubError result = null;

            if (objectError instanceof FieldError fieldError) {
                result = ApiValidationSubError.builder()
                        .object(objectError.getObjectName())
                        .message(objectError.getDefaultMessage())
                        .field(fieldError.getField())
                        .rejectValue(String.valueOf(fieldError.getRejectedValue()))
                        .build();
            } else {
                result = ApiValidationSubError.builder()
                        .object(objectError.getObjectName())
                        .message(objectError.getDefaultMessage())
                        .build();
            }

            return result;

        }

    }
}
