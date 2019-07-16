package com.marketing.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.marketing.model.Transaction;
import com.marketing.service.impl.ImportServiceImpl;

public class ImportServiceImplTest {

	/**
	 * Unit test for importFromFile
	 */
	@Test
	public void testImportFromFile() {
		
		List<Transaction> transactionList = ImportServiceImpl.importFromFile("./resources/test_input.txt");
		
		assertEquals(1, transactionList.size());
		assertEquals("CL  ", transactionList.get(0).getClientType());
		assertEquals("4321", transactionList.get(0).getClientNumber());
		assertEquals("0002", transactionList.get(0).getAccountNumber());
		assertEquals("0001", transactionList.get(0).getSubaccountNumber());
		assertEquals("SGX ", transactionList.get(0).getExchangeCode());
		assertEquals("FU", transactionList.get(0).getProducGroupCode());
		assertEquals("NK    ", transactionList.get(0).getSymbol());
		assertEquals("20100910", transactionList.get(0).getExpirationDate());
		assertEquals(1, transactionList.get(0).getQuantityLong());
		assertEquals(0, transactionList.get(0).getQuantityShort());
	}

}
