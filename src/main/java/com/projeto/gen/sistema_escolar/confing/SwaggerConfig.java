package com.projeto.gen.sistema_escolar.confing;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	 @Bean
	    public GroupedOpenApi alunosApi() {
	        return GroupedOpenApi.builder()
	                .group("alunos-api")
	                .pathsToMatch("/alunos/**")
	                .build();
	    }
}