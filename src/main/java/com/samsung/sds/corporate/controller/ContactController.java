package com.samsung.sds.corporate.controller;

import com.samsung.sds.corporate.payload.ContactPayload;
import com.samsung.sds.corporate.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;

@Controller
@RequestMapping(value = "/api/v2")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    private final ResourceBundleMessageSource messageSource;

    @PostMapping(value = "/contact")
    public ResponseEntity<String> create(@RequestBody ContactPayload payload) throws URISyntaxException {
        service.save(payload);
        var msg = messageSource.getMessage("contact.form.message.alert.success", null, LocaleContextHolder.getLocale());
        return ResponseEntity.ok(msg);
    }
}
