/**
 * 
 */
package com.marketing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.marketing.model.Transaction;

/**
 * @author jason.chen
 *
 */
public class SummaryServiceImpl{

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private final static String COMMA_DELIMITER = ",";
	
	private final static String NEW_LINE = "\n";
	
	/**
	 * Generate summary report content basing on transaction list 
	 * 
	 * @param transactionList
	 * @return summary report content
	 */
	public static String generateSummaryFromTransationList(List<Transaction> transactionList) {
		
		HashMap<String, Integer> summary = new HashMap<String, Integer>();
		String clientAndProduct = new String();
		StringBuilder stringBuilder = new StringBuilder();
		Integer transationAmount;
		LOGGER.log(Level.INFO, "Generate summary content start...");
		// group and calculate total transaction amount for each client and product combination
		for(Transaction transaction: transactionList){
			stringBuilder = new StringBuilder();
			stringBuilder.append(transaction.getClientType());
			stringBuilder.append(transaction.getClientNumber());
			stringBuilder.append(transaction.getAccountNumber());
			stringBuilder.append(transaction.getSubaccountNumber());
			stringBuilder.append(COMMA_DELIMITER);
			stringBuilder.append(transaction.getExchangeCode());
			stringBuilder.append(transaction.getProducGroupCode());
			stringBuilder.append(transaction.getSymbol());
			stringBuilder.append(transaction.getExpirationDate());
			clientAndProduct = stringBuilder.toString();
			transationAmount = transaction.getQuantityLong() - transaction.getQuantityShort();
			if(summary.containsKey(clientAndProduct)){
				summary.put(clientAndProduct, summary.get(clientAndProduct) + transationAmount);
			} else {
				summary.put(clientAndProduct, transationAmount);
			}
		}
		// add csv headers
		stringBuilder = new StringBuilder();
		stringBuilder.append("Client_Information");
		stringBuilder.append(COMMA_DELIMITER);
		stringBuilder.append("Product_Information");
		stringBuilder.append(COMMA_DELIMITER);
		stringBuilder.append("Total_Transaction_Amount");
		stringBuilder.append(NEW_LINE);
		// convert to output format
		for(String info: summary.keySet()){
			stringBuilder.append(info);
			stringBuilder.append(COMMA_DELIMITER);
			stringBuilder.append(String.valueOf(summary.get(info)));
			stringBuilder.append(NEW_LINE);
		}
		LOGGER.log(Level.INFO, "Generate summary content end...");
		return stringBuilder.toString();
	}

}
