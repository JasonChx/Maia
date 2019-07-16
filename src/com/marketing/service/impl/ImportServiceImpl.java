/**
 * 
 */
package com.marketing.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.marketing.model.Transaction;

/**
 * @author jason.chen
 *
 */
public class ImportServiceImpl {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private final static int TOTAL_LENGTH_BEFORE_FILLER = 176;

	private final static String RECODE_CODE = "315";

	/**
	 * Import transaction from input file
	 * 
	 * @param fileName
	 * @return list of transaction record
	 */
	public static List<Transaction> importFromFile(String fileName) {
		// test file from resources folder
// 		File input = new File("./resources/" + fileName);

		File input = new File(fileName);

		List<Transaction> transactionList = new ArrayList<Transaction>();

		try {
			// read file
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			LOGGER.log(Level.INFO, "Import file start...");
			String thisLine = null;
			Transaction transaction = null;
			while ((thisLine = br.readLine()) != null) {
				if (!thisLine.isEmpty()) {
					if (thisLine.length() == TOTAL_LENGTH_BEFORE_FILLER && thisLine.startsWith(RECODE_CODE)) {
						// create transaction entry
						transaction = new Transaction();
						transaction.setClientType(thisLine.substring(3, 7));
						transaction.setClientNumber(thisLine.substring(7, 11));
						transaction.setAccountNumber(thisLine.substring(11, 15));
						transaction.setSubaccountNumber(thisLine.substring(15, 19));
						transaction.setExchangeCode(thisLine.substring(27, 31));
						transaction.setProducGroupCode(thisLine.substring(25, 27));
						transaction.setSymbol(thisLine.substring(31, 37));
						transaction.setExpirationDate(thisLine.substring(37, 45));
						transaction.setQuantityLong(Integer.valueOf(thisLine.substring(52, 62)));
						transaction.setQuantityShort(Integer.valueOf(thisLine.substring(63, 73)));
						transactionList.add(transaction);
					} else {
						LOGGER.log(Level.WARNING, "Skip: Line in wrong format:\n" + thisLine);
					}
				}
			}
			LOGGER.log(Level.INFO, "Import file end...");
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.SEVERE, "Input file not found.");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Input file error.");
		}

		return transactionList;
	}

}
