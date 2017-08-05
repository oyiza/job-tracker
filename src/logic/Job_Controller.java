package logic;

import java.util.Scanner;

import exception.JobNotFoundException;

public class Job_Controller {
	
	public void run() {
		
		Job_Logic jobs = new Job_Logic();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Welcome to your home page. Please choose one option:");
			System.out.println("1. View Jobs."
					+ "\n2. Add Job."
					+ "\n3. Search Job."
					+ "\n4. Update Job information."
					+ "\n5. Delete Job."
					+ "\n6. Quit.");
			int option = sc.nextInt();
			
			switch(option) {
			//View Jobs
			case 1:
				try{
					jobs.displayJobs();
				} catch(JobNotFoundException e) {
					System.out.println(e.toString());
				}
				break;
			//Add Job
			case 2:
				jobs.createJob();
				System.out.println();
				break;
			//Search Job
			case 3:
				jobs.searchJob();
				break;
			//Update Job information
			case 4:
				try {
					jobs.updateJob();
				} catch(JobNotFoundException e) {
					System.out.println(e.toString());
				}
				break;
			//Delete Job
			case 5:
				try {
					jobs.deleteJob();
				} catch (JobNotFoundException e) {
					System.out.println(e.toString());
				}
				break;
			//Quit
			case 6:
				System.out.println("Goodbye!");
				sc.close();
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		Job_Controller system = new Job_Controller();
		try {
			system.run();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}