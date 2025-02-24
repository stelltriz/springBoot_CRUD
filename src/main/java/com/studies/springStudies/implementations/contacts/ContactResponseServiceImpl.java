package com.studies.springStudies.implementations.contacts;

import com.studies.springStudies.models.records.contacts.ContactDataResponse;
import com.studies.springStudies.repositories.ContactRepository;
import com.studies.springStudies.services.contacts.ContactResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactResponseServiceImpl implements ContactResponseService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactResponseServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> response(){
        List<ContactDataResponse> contactsList = contactRepository.findAll().stream().map(ContactDataResponse::new).toList();

        HashMap<String, Object> body = new HashMap<>();
        body.put("message", contactsList);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
