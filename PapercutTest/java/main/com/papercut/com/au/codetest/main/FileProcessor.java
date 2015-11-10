package com.papercut.com.au.codetest.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileProcessor {

	private final int BNWSINGLE = 15;
	private final int COLOURSINGLE = 25;
	private final int BNWDOUBLE = 10;
	private final int COLOURDOUBLE = 20;
	
	public void processFile(String csvFile) {
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
		List<PrintJob> printJobs = new ArrayList<PrintJob>();
		
		int totalCost = 0;
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			
			
			while ((line = br.readLine()) != null) {
				
				int numBnw = 0;
				int numColour = 0;
				int cost = 0;
				
				String[] jobRows = line.split(cvsSplitBy);
				
				
				PrintJob pJob = new PrintJob();
				
				pJob.setNumOfPages(Integer.valueOf(jobRows[0].trim()));
				pJob.setNumOfColourPages(Integer.valueOf(jobRows[1].trim()));
				boolean isDoub = (jobRows[2].trim().equals("true")) ? true : false;
				pJob.setDoubleSided(isDoub);
				
				if(isDoub){
					//double sided				
					numBnw = pJob.getNumOfPages() - pJob.getNumOfColourPages();
					numColour = pJob.getNumOfColourPages();
					cost = (numBnw * BNWDOUBLE) +  (numColour * COLOURDOUBLE);
					
				}else{
					//coloured
					numBnw = pJob.getNumOfPages() - pJob.getNumOfColourPages();
					numColour = pJob.getNumOfColourPages();
					cost = (numBnw * BNWSINGLE) +  (numColour * COLOURSINGLE);
				}
				
				totalCost += cost;
				System.out.println("total pages=" + jobRows[0].trim() + " , num of color pages=" + jobRows[1].trim() + " , are pages doublesided=" + jobRows[2].trim() +  ", job cost:" + n.format(cost / 100.0));
				pJob.setJobCost(n.format(cost / 100.0));
				printJobs.add(pJob);
				
			}
			
			
			System.out.println("total print cost:"+ n.format(totalCost / 100.0));
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	  }
	
	
	 
	
	
	
}
