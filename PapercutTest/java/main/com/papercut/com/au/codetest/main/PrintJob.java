package com.papercut.com.au.codetest.main;

public class PrintJob {

	private int numOfPages;
	private int numOfColourPages;
	private boolean isDoubleSided;
	
	private String jobCost;
	
	
	public String getJobCost() {
		return jobCost;
	}
	public void setJobCost(String jobCost) {
		this.jobCost = jobCost;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public int getNumOfColourPages() {
		return numOfColourPages;
	}
	public void setNumOfColourPages(int numOfColourPages) {
		this.numOfColourPages = numOfColourPages;
	}
	public boolean isDoubleSided() {
		return isDoubleSided;
	}
	public void setDoubleSided(boolean isDoubleSided) {
		this.isDoubleSided = isDoubleSided;
	}
	
	
}
