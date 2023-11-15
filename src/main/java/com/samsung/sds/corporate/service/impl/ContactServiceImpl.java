package com.samsung.sds.corporate.service.impl;

import com.samsung.sds.corporate.model.Contact;
import com.samsung.sds.corporate.payload.ContactPayload;
import com.samsung.sds.corporate.repository.ContactRepository;
import com.samsung.sds.corporate.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    public Contact findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Integer save(ContactPayload contactPayload) throws DataIntegrityViolationException {
        var contact = new Contact();
        BeanUtils.copyProperties(contactPayload, contact);
        return repository.save(contact).getId();
    }

    @Override
    public void update(Integer id, ContactPayload contactPayload) {
        var contact = this.findById(id);
        if (contact != null) {
            BeanUtils.copyProperties(contactPayload, contact);
            repository.save(contact);
        }
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
