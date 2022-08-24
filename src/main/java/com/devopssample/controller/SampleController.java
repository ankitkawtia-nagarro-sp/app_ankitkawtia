package com.devopssample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/")
    	String hello() {
        	return "Hello World! I am from Develop branch";
    }

}
