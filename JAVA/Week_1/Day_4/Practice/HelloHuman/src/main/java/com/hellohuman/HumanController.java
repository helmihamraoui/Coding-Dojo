package com.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="firstName", required=false) String firstName,@RequestParam(value="lastName", required=false) String lastName,@RequestParam(value="times", required=false) Integer times) {
		if(lastName!=null && firstName!=null) {
			return "Hello "+ firstName+" "+lastName+" ";
		}
		if(firstName!=null && times >= 2) {
			String str ="";
			int i = 1;
			while(i<=times) {
				str+= i+"- Hello "+ firstName+" <br> " ;
				i++;
			}
			return str;
		}
		if(firstName!=null) {
			return "Hello " + firstName ;
		}
		return "Hello Human";
	}
}
