/**
 * 
 */
package com.marketing.service.impl;

import java.util.HashMap;
import java.util.List;
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
	
	public static String generateSummaryFromTransationList(List<Transaction> transactionList) {
		
		HashMap<String, Long> summary = new HashMap<String, Long>();
		String clientAndProduct = new String();
		StringBuilder stringBuilder = new StringBuilder();
		Long transationAmount;
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
		stringBuilder = new StringBuilder();
		stringBuilder.append("Client_Information");
		stringBuilder.append(COMMA_DELIMITER);
		stringBuilder.append("Product_Information");
		stringBuilder.append(COMMA_DELIMITER);
		stringBuilder.append("Total_Transaction_Amount");
		stringBuilder.append(NEW_LINE);
		for(String info: summary.keySet()){
			stringBuilder.append(info);
			stringBuilder.append(COMMA_DELIMITER);
			stringBuilder.append(String.valueOf(summary.get(info)));
			stringBuilder.append(NEW_LINE);
		}
		
		return stringBuilder.toString();
	}

}
