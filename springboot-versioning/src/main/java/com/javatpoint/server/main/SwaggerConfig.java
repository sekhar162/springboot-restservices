package com.javatpoint.server.main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//Configuration
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig 
{
//configuring the contact detail
public static final Contact DEFAULT_CONTACT = new Contact("Andrew", "http://www.javatpoint.com", "javatpoint");
//configuring DEFAULT_API_INFO
public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("RESTful API Demo", "Api Documentation Demo", "1.0", "urn:tos",
DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
//two format which we want to produce and consume
private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","appication/xml"));
//creating bean
@Bean
public Docket api()
{
ApiInfo apiInfo;
return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES);
}
}
