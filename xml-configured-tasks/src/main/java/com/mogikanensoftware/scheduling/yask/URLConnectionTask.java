package com.mogikanensoftware.scheduling.yask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("urlConnectionTask")
public class URLConnectionTask {

	 private static final String CON_URL = "https://mogikanen9.github.io/";
	private static final Logger log = LoggerFactory.getLogger(URLConnectionTask.class);
	
	public void connect() throws InterruptedException{
		try {
		    URL myURL = new URL(CON_URL);
		    URLConnection myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		    log.info(String.format("Successfully connected to %s", CON_URL));
		    Thread.sleep(5000);
		} 
		catch (MalformedURLException e) { 
		    log.error(e.getMessage());
		} 
		catch (IOException e) {   
		    log.error(e.getMessage());		}
	}
}
