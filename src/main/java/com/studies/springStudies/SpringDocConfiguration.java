package com.studies.springStudies;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration // Indica que esta classe contém configurações do Spring
public class SpringDocConfiguration {

    @Bean // Define um bean que será gerenciado pelo Spring
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key", new SecurityScheme() // Configura autenticação Bearer Token (JWT)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("springStudies") // Título da documentação da API
                        .version("1.0") // Versão da API
                        .description("API documentation for the springStudies project.") // Descrição da API
                        .termsOfService("") // URL dos termos de serviço (se houver)
                        .license(new License()
                                .name("") // Nome da licença (se houver)
                                .url(""))); // URL da licença (se houver)
    }
}

