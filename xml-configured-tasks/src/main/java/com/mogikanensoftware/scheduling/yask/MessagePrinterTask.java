package com.mogikanensoftware.scheduling.yask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("messagePrinterTask")
public class MessagePrinterTask {

	 private static final Logger log = LoggerFactory.getLogger(MessagePrinterTask.class);

	
	public void printMessage(){
		log.info(String.format("Hello message at %s", System.currentTimeMillis()));
	}
}
