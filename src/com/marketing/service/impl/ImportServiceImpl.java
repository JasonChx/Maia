/**
 * 
 */
package com.marketing.service.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jason.chen
 *
 */
public class ImportServiceImpl{

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void importFromFile(String fileName) {
		System.out.println("importFromFile");
		
		File input = new File("./resources/"+fileName);
		
//		File input = new File(fileName);
		
		LOGGER.log(Level.INFO, String.valueOf(input.exists()));
		
		LOGGER.log(Level.INFO, input.getAbsolutePath());
		
		LOGGER.log(Level.INFO, "importFromFile1");
	}

}
