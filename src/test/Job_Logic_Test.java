package test;

import exception.JobNotFoundException;
import logic.Job_Logic;

public class Job_Logic_Test {

	public static void main(String[] args) {
		Job_Logic test = new Job_Logic();
		
		//Test JobNotFoundException class
		System.out.println("....Testing JobNotFoundException class (using displayJobs())....");
		try {
			test.displayJobs();
		} catch(JobNotFoundException e) {
			System.out.println(e);
		}
		
		System.out.println("....Testing JobNotFoundException class (using searchJobs()).....");
		System.out.println("Enter any job position. Should throw an exception because there are no"
				+ " jobs currently.");
		test.searchJob();
		
		//Test Creating a job
		System.out.println(".....Testing createJob().....");
		test.createJob();
		System.out.println("....Job creating done. Printing out the details of job....");
		try {
			test.displayJobs();
		} catch(JobNotFoundException e) {
			System.out.println(e);
		}
		
		//Test searching jobs
		
		//Test Updating job information
		
		//Test Deleting jobs
	}
}