package com.zycryx.olympus.web.config;

import com.fasterxml.classmate.TypeResolver;
import com.zycryx.olympus.web.exception.ErrorDetailDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {

    private static final List<Response> DEFAULT_MESSAGES = Arrays.asList(
            new ResponseBuilder()
                    .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .description(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .representation(MediaType.APPLICATION_JSON)
                    .apply(SwaggerConfiguration::buildDefaultModel )
                    .isDefault(true)
                    .build(),
            new ResponseBuilder()
                    .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                    .description(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                    .representation(MediaType.APPLICATION_JSON)
                    .apply(SwaggerConfiguration::buildDefaultModel)
                    .isDefault(true)
                    .build());

    private static void buildDefaultModel(final RepresentationBuilder representationBuilder) {
        representationBuilder.model(msBuilder -> msBuilder.name("ErrorDTO")
                .referenceModel(rmsBuilder ->
                        rmsBuilder.key(
                                        mkBuilder ->
                                                mkBuilder.isResponse(true)
                                                        .qualifiedModelName(
                                                                qmnBuilder -> qmnBuilder.name("ErrorDetailDTO")
                                                                        .namespace("com.olympus.platform.exception")
                                                                        .build())
                                                        .build())
                                .build())
                .build());
    }

    @Bean
    public Docket swagger(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.OPTIONS, DEFAULT_MESSAGES)
                .globalResponses(HttpMethod.HEAD, DEFAULT_MESSAGES)
                .globalResponses(HttpMethod.GET, DEFAULT_MESSAGES)
                .globalResponses(HttpMethod.PATCH, DEFAULT_MESSAGES)
                .globalResponses(HttpMethod.POST, DEFAULT_MESSAGES)
                .globalResponses(HttpMethod.PUT, DEFAULT_MESSAGES)
                .globalResponses(HttpMethod.DELETE, DEFAULT_MESSAGES)
                .additionalModels(typeResolver.resolve(ErrorDetailDTO.class))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.olympus.platform.controller"))
                .paths(PathSelectors.ant("/olympus/api/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Olympus Platform Backend Services")
                .description("Olympus Platform Backend Services - Microservices for Multiplatform devices")
                .version("1.0.0.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .operationSelector(operationContext -> true).build();
    }

    private List<SecurityReference> defaultAuth() {
        var authorizationScope = new AuthorizationScope("global", "accessEverything");
        var authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
    }
}

