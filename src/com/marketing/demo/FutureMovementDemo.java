/**
 * 
 */
package com.marketing.demo;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.marketing.model.Transaction;
import com.marketing.service.impl.ExportServiceImpl;
import com.marketing.service.impl.ImportServiceImpl;
import com.marketing.service.impl.LoggingServiceImpl;
import com.marketing.service.impl.SummaryServiceImpl;

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
			List<Transaction> transactionList = ImportServiceImpl.importFromFile(args[0]);
			
			String summary = SummaryServiceImpl.generateSummaryFromTransationList(transactionList);
			
			ExportServiceImpl.exportToFile(summary);
		} else {
			LOGGER.log(Level.SEVERE, "No file input");
		}
		
		
	}

}
