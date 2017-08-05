package test;

import exception.JobNotFoundException;
import logic.Job_Logic;

public class Job_Logic_Test {
	
	//Might want to use junit to test this but will have to learn that first..

	public static void main(String[] args) {
		Job_Logic test = new Job_Logic();
		
		//Test displayJobs() method
		System.out.println("....Testing displayjobs() class....");
		try {
			test.displayJobs();
		} catch(JobNotFoundException e) {
			System.out.println("Success... JobNotFoundException thrown as expected!");
		} catch(Exception e) {
			System.out.println("Error...unknown exception thrown...");
		}
		
		//TODO how do I test methods that use user input without bothering the user at all?
		System.out.println("....Testing searchJobs().....");
		test.searchJob();
		
		//Test Creating a job
//		System.out.println(".....Testing createJob().....");
//		test.createJob();
//		System.out.println("....Job creating done. Printing out the details of job....");
//		try {
//			test.displayJobs();
//		} catch(JobNotFoundException e) {
//			System.out.println(e);
//		}
		
		//Test Updating job information
		
		//Test Deleting jobs
	}
}