/**
 * 
 */
package com.marketing.model;

/**
 * @author jason.chen
 *
 */
public class Transaction {
	
	private String clientType;
	
	private String clientNumber;
	
	private String accountNumber;
	
	private String subaccountNumber;
	
	private String exchangeCode;
	
	private String producGroupCode;
	
	private String symbol;
	
	private String expirationDate;
	
	private long quantityLong;
	
	private long quantityShort;

	
	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSubaccountNumber() {
		return subaccountNumber;
	}

	public void setSubaccountNumber(String subaccountNumber) {
		this.subaccountNumber = subaccountNumber;
	}

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public String getProducGroupCode() {
		return producGroupCode;
	}

	public void setProducGroupCode(String producGroupCode) {
		this.producGroupCode = producGroupCode;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public long getQuantityLong() {
		return quantityLong;
	}

	public void setQuantityLong(long quantityLong) {
		this.quantityLong = quantityLong;
	}

	public long getQuantityShort() {
		return quantityShort;
	}

	public void setQuantityShort(long quantityShort) {
		this.quantityShort = quantityShort;
	}

}
