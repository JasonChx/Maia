/**
 * 
 */
package com.marketing.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jason.chen
 *
 */
public class ExportServiceImpl{

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void exportToFile(String summary) {
		try {
			FileWriter fw = new FileWriter("Output.csv");
			fw.write(summary);
			fw.close();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fail to create output file.");
		}
		
	}

}
