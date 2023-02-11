package com.javatpoint.server.main;
import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
@SpringBootApplication
public class RestfulWebServicesApplication  
{
public static void main(String[] args) 
{
SpringApplication.run(RestfulWebServicesApplication.class, args);
}
//configuring default locale
@Bean
public  LocaleResolver localeResolver()
{
AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
localeResolver.setDefaultLocale(Locale.US);
return localeResolver;
}
/*
//configuring ResourceBundle
@Bean
public ResourceBundleMessageSource messageSource()
{
ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
messageSource.setBasename("messages");
return messageSource;
}
*/
}