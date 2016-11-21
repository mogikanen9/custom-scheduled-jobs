package com.mogikanensoftware.scheduling.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("myTimeBean")
public class MyTimeBean {
	
	private static final Logger log = LoggerFactory.getLogger(MyTimeBean.class);

	public void printMyTime() {
		log.info(String.format("My Time in ms. ->%s", System.currentTimeMillis()));
	}
}
