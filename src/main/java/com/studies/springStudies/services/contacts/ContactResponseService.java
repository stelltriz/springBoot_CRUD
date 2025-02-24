package com.studies.springStudies.services.contacts;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ContactResponseService {
    ResponseEntity<Map<String, Object>> response();
}
