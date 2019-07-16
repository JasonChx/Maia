package com.marketing.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.marketing.service.impl.ExportServiceImpl;

public class ExportServiceImplTest {

	/**
	 * Unit test for exportToFile()
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testExportToFile() throws FileNotFoundException {
		String summary = "Client_Information,Product_Information,Total_Transaction_Amount\nCL  432100020001,SGX FUNK    20100910,1\n";
		
		ExportServiceImpl.exportToFile(summary);
		
		File output = new File("Output.csv");
		
		assertTrue(output.exists());
		
		File expectedOutput = new File("./resources/test_output.csv");
		
		FileReader fr = new FileReader(output);
		BufferedReader br = new BufferedReader(fr);
		
		FileReader efr = new FileReader(expectedOutput);
		BufferedReader ebr = new BufferedReader(efr);
		
		try {
			assertEquals(ebr.readLine(), br.readLine());
			
			assertEquals(ebr.readLine(), br.readLine());
			
			assertEquals(ebr.readLine(), br.readLine());
		} catch (IOException e) {
			fail("Error occurs on reading output file.");
		}
		
	}

}
