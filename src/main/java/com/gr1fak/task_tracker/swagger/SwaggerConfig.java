package com.gr1fak.task_tracker.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI customerAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Task-Tracker API")
                            .version("1.0.0")
                            .contact(
                                    new Contact()
                                        .email("vadim-nepom@mail.ru")
                                        .url("https://vk.com/not_remembering")
                                        .name("Nepomnyaschii Vadim")
                        )
                );
    }
}
