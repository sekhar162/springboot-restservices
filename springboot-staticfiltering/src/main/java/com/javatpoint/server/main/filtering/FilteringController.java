package com.javatpoint.server.main.filtering;  
import java.util.Arrays;  
import java.util.List;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class FilteringController   
{  
//returning a single bean as response  
@RequestMapping("/filtering")  
public SomeBean retrieveSomeBean()  
{  
return new SomeBean("sekhar", "9999999999","39000");  
}  
//returning a list of SomeBeans as response  
@RequestMapping("/filtering-list")  
public List<SomeBean> retrieveListOfSomeBeans()  
{  
return Arrays.asList(new SomeBean("Saurabh", "8888888888","20000"), new SomeBean("Devesh", "1111111111","34000"));  
}  
}  