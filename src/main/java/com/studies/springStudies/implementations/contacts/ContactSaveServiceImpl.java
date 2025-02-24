package com.studies.springStudies.implementations.contacts;

import com.studies.springStudies.exceptions.RegraDeNegocioException;
import com.studies.springStudies.models.Contact;
import com.studies.springStudies.models.records.contacts.ContactData;
import com.studies.springStudies.models.records.contacts.ContactDataResponse;
import com.studies.springStudies.repositories.ContactRepository;
import com.studies.springStudies.services.contacts.ContactSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContactSaveServiceImpl implements ContactSaveService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactSaveServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> save(ContactData contactData){

        if(contactRepository.existsByNumber(contactData.phone())){
            throw new RegraDeNegocioException("Este número já está em sua agenda");
        }

        Contact contact = new Contact();

        if(contactData.name() != null){
            contact.setName(contactData.name());
        }

        if(contactData.phone() != null){
            contact.setPhone(contactData.phone());
        }

        if(contactData.email() != null){
            contact.setEmail(contactData.email());
        }

        contactRepository.save(contact);

        HashMap<String, Object> body = new HashMap<>();
        body.put("message", new ContactDataResponse(contact));

        return new ResponseEntity<>(body, HttpStatus.CREATED);

    }

}
