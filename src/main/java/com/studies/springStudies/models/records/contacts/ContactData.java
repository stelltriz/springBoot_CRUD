package com.studies.springStudies.models.records.contacts;

import jakarta.validation.constraints.NotBlank;

public record ContactData(
        @NotBlank(message = "Name must not be blank")
        String name,
        @NotBlank(message = "Phone must not be blank")
        String phone,
        @NotBlank(message = "E-mail must not be blank")
        String email
) {
}
