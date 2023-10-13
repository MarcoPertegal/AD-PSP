package com.salesianostriana.dam._ejemploopenapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
para acceder desde postman
Nos devuelve un json con el contrato que documenta nuestra api rest
La ventaja es que la documentacion se va a generar automaticamente a partir de los
controladores, por lo que no es estatica sino que se va actualizando por si introducimos
una actualizacion de nuestra aplicacion
http://localhost:8080/swagger-ui/index.html

Para acceder desde navegador para no usar postaman
Desde postman se pueden acceder a muchos datos es recomendable usarlo
=============================================
IMPORTANTE
Se ha añadido una dependencia diferente al curso de alan y un comando en application properties

=========================================
 */
@Configuration
public class OpenApiConfig {

    //postman podria leer esta información por lo que es util a la hora de testear
    //las apis
    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(
                new Info()
                        .title("Employees API")
                        .description("API REST para empleados de la empresa X")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://www.example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Wiki docs")
                        .url("https://www.example.com"));
    }
}
