package com.marketing.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.marketing.model.Transaction;
import com.marketing.service.impl.SummaryServiceImpl;

public class SummaryServiceImplTest {

	/**
	 * Unit test for generateSummaryFromTransationList
	 */
	@Test
	public void testGenerateSummaryFromTransationList() {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setClientType("CL  ");
		transaction.setClientNumber("4321");
		transaction.setAccountNumber("0002");
		transaction.setSubaccountNumber("0001");
		transaction.setExchangeCode("SGX ");
		transaction.setProducGroupCode("FU");
		transaction.setSymbol("NK    ");
		transaction.setExpirationDate("20100910");
		transaction.setQuantityLong(1);
		transaction.setQuantityShort(0);
		
		transactionList.add(transaction);
		String summary = SummaryServiceImpl.generateSummaryFromTransationList(transactionList);

		assertEquals("Client_Information,Product_Information,Total_Transaction_Amount\nCL  432100020001,SGX FUNK    20100910,1\n", summary);
	}
}
