package com.samsung.sds.corporate.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final ResourceBundleMessageSource messageSource;
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleVoEx() {
        var msg = messageSource.getMessage("contact.form.message.alert.error", null, LocaleContextHolder.getLocale());
        return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.CONFLICT);
    }
}
