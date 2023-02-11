package com.javatpoint.server.main.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
@Configuration
//Controller
@RestController
public class HelloWorldController 
{
@Autowired 
private MessageSource messageSource;
//using get method and hello-world URI
@GetMapping(path="/hello-world")
public String helloWorld()
{
return "Hello World";
}
@GetMapping(path="/hello-world-bean")
//method- which returns "Hello World"
public HelloWorldBean helloWorldBean()
{
return new HelloWorldBean("Hello World");//constructor of HelloWorldBean
}
//passing a path variable 
//hello-world/path-variable/javatpoint
@GetMapping(path="/hello-world/path-variable/{name}")
public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
{
return new HelloWorldBean(String.format("Hello World, %s",name));	//%s replace the name
}
//internationalization
@GetMapping(path="/hello-world-internationalized")
public String helloWorldInternationalized()
{
return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
}
}
