package com.filali.gestiodestock.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Firas",
                        email = "firas.fileli@gmail.com"
                ),
                description = "Gestion de stock API documentation",
                title = "Gestion de stock REST API",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Development",
                        url = "http://localhost:8082"
                )

        }
)
public class SwaggerConfiguration {

}
