package com.websystiwue.springmv.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websystiwue.springmv.db.GetHello;
import com.websystiwue.springmv.domain.Message;



@RestController
public class HelloWorldRestController {

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {
		
//		Message msg = new Message(player, "Hello " + player);
//
		GetHello gH = new GetHello(player);
		Message msg = gH.getHello();
		return msg;
		
	}
	
	
	
	
}
