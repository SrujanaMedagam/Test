package com.valuelabs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hello")
public class RestController {
	@RequestMapping(value="/test/{name}", method=RequestMethod.GET)
	public String gettest(@PathVariable String name){
		String result="Hello "+name;
		return result;
		
	}

}
