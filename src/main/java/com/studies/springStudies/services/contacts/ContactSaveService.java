package com.studies.springStudies.services.contacts;

import com.studies.springStudies.models.records.contacts.ContactData;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ContactSaveService {
    ResponseEntity<Map<String, Object>> save(ContactData contactData);
}
