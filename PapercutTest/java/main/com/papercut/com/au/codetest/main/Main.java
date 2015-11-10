package com.papercut.com.au.codetest.main;

public class Main {

	
	
	
	 public static void main(String[] args) {
		 String csvFile;
		 
		 if (args.length == 0){
			 csvFile = "./printjobs.csv";
		 }else{
			 csvFile = args[0];
		 }
		  
		 FileProcessor obj = new FileProcessor();
			obj.processFile(csvFile);

		  }
	
	
}
