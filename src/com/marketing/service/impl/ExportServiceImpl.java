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
	
	/**
	 * Write summary report content into a csv file
	 * 
	 * @param summary
	 */
	public static void exportToFile(String summary) {
		try {
			LOGGER.log(Level.INFO, "Export file start...");
			FileWriter fw = new FileWriter("Output.csv");
			fw.write(summary);
			fw.close();
			LOGGER.log(Level.INFO, "Export file end...");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fail to create output file.");
		}
		
	}

}
