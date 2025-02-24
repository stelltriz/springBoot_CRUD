package com.studies.springStudies.controllers.contacts;

import com.studies.springStudies.models.records.contacts.ContactData;
import com.studies.springStudies.services.contacts.ContactResponseService;
import com.studies.springStudies.services.contacts.ContactSaveService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactSaveService contactSaveService;
    private final ContactResponseService contactResponseService;

    @Autowired
    public ContactController(ContactSaveService contactSaveService, ContactResponseService contactResponseService){
        this.contactSaveService = contactSaveService;
        this.contactResponseService = contactResponseService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Valid ContactData contactData){
        return contactSaveService.save(contactData);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        return  contactResponseService.response();
    }
}
