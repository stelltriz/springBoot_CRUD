package com.studies.springStudies.repositories;

import com.studies.springStudies.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByName(String name);
    boolean existsByPhone(String phone);
}
