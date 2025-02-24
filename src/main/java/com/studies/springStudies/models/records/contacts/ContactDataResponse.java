package com.studies.springStudies.models.records.contacts;

import com.studies.springStudies.models.Contact;

public record ContactDataResponse(
        Integer id,
        String name,
        String phone,
        String email
) {
    public ContactDataResponse(Contact contact){
        this(
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getEmail()
        );
    }
}
