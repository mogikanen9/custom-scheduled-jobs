package com.mogikanensoftware.scheduling.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("sayHelloBean")
public class SayHelloBean {

	private static final Logger log = LoggerFactory.getLogger(SayHelloBean.class);
	
	public void sayHello(){
		log.info("Hello, World!");
	}
}
