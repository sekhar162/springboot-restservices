package com.javatpoint.server.main.versioning;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PersonVersoningController {
	//1 uri versioning
//this method is for the first version that returns the entire name  
	@GetMapping("v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Tom Cruise");
	}

	// uri versioning
//this method is for the second version that returns firstName and lastName separately  
	@GetMapping("v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Tom", "Cruise"));
	}

	//2 Request parameter versioning
//this method is for first version that returns the entire name  
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 personV1() {
		return new PersonV1("Tom Cruise");
	}

	// Request parameter versioning
//this method is for second version that returns firstName and lastName separately  
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Tom", "Cruise"));
	}
	
	/*3---------------using request header--------------*/  
	//this method is for first version that returns the entire name  
	@GetMapping(value="/person/header", headers="X-API-Version=1")  
	public PersonV1 headerV1()  
	{  
	return new PersonV1("Tom Cruise");  
	}  
	//this method is for second version that returns firstName and lastName separately  
	@GetMapping(value="/person/header", headers="X-API-Version=2")  
	public PersonV2 headerV2()  
	{  
	return new PersonV2(new Name("Tom", "Cruise"));  
	}  
	
	/*4---------------using accept header--------------*/  
	//this method is for first version that returns the entire name  
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")  
	public PersonV1 producesV1()  
	{  
	return new PersonV1("Tom Cruise");  
	}
	//not working 
	//this method is for second version that returns firstName and lastName separately  
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")  
	public PersonV2 producesV2()  
	{  
	return  new PersonV2(new Name("Tom", "Cruise"));  
	}  
}