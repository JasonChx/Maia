/**
 * 
 */
package com.marketing.demo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.marketing.service.impl.ImportServiceImpl;
import com.marketing.service.impl.LoggingServiceImpl;

/**
 * @author jason.chen
 *
 */
public class FutureMovementDemo {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		LoggingServiceImpl.setup();
		
		if(args.length == 1){
			ImportServiceImpl.importFromFile(args[0]);
			
			
			
			
		} else {
			LOGGER.log(Level.SEVERE, "No file input");
		}
		
		
	}

}
