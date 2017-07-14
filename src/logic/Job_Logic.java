package logic;

import classes.Job;
import exception.JobNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Job_Logic {
	
	//List of jobs that the system keeps track of
	ArrayList<Job> jobs = new ArrayList<Job>();
	//Unique ID for the job
	int id = 101;
	
	/**
	 * Boss search method that determines what methods to call based on position, company name or
	 * status
	 */
	public void searchJob() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Job> temp = new ArrayList<Job>();
		System.out.println("How would you like to search?\n1 - By Position\n2 - By Company Name"
				+ "\n3 - By Status");
		int option = sc.nextInt();
		sc.nextLine();/*It seems I need this here or else there would be an empty string waiting to be
		read in*/
		
		switch(option) {
		//By position
		case 1:
			System.out.println("Please enter position:");
//			System.out.println(sc.nextLine());//DEBUG
			String position = sc.nextLine();
//			System.out.println("Position is: " + position);//DEBUG
			try{
				temp = searchJobByPosition(position);
			} catch(JobNotFoundException e) {
				System.out.println(e);
			}
			break;
		//By Company name
		case 2:
			System.out.println("Please enter company name:");
			String companyName = sc.nextLine();
			
			try{
				temp = searchJobByCompanyName(companyName);
			} catch(JobNotFoundException e) {
				System.out.println(e);
			}
			break;
		//By Status
		case 3:
			//TODO probably give the user the statuses and have them pick an option
			System.out.println("Please enter status:");
			String status = sc.nextLine();
			
			try{
				temp = searchJobByStatus(status);
			} catch(JobNotFoundException e) {
				System.out.println(e);
			}
			break;
		}
		
		//print the jobs to console
		Iterator<Job> itr = temp.iterator();
		Job use;
		int count = 1;
		
		while(itr.hasNext()) {
			use = itr.next();
			System.out.println(count + ". " + use.toString() + "\n");
			count++;
		}
	}
	
	/**
	 * Search method to return jobs by specific position
	 * @return an ArrayList containing all jobs with job title as position
	 * @throws JobNotFoundException
	 */
	private ArrayList<Job> searchJobByPosition(String position)  throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		boolean found = false;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getPosition().equalsIgnoreCase(position)) {
				result.add(temp);
				found = true;
			}
		}
		
		if(!found) {
			throw new JobNotFoundException();
		} else {
			System.out.println("Jobs that match position '" + position + "' are:");
			return result;
		}
	}
	
	/**
	 * Search method to return jobs by specific company name
	 * @return an ArrayList containing all jobs with company name as companyName 
	 * @throws JobNotFoundException
	 */
	private ArrayList<Job> searchJobByCompanyName(String companyName) throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		boolean found = false;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getCompanyName().equalsIgnoreCase(companyName)) {
				result.add(temp);
				found = true;
			}
		}
		
		if(!found) {
			throw new JobNotFoundException();
		} else {
			System.out.println("Jobs that match company name '" + companyName + "' are:");
			return result;
		}
	}
	
	/**
	 * Search method to return jobs by specific status
	 * @return an ArrayList containing all jobs with specified status
	 * @throws JobNotFoundException
	 */
	private ArrayList<Job> searchJobByStatus(String status) throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		boolean found = false;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getStatus().equalsIgnoreCase(status)) {
				result.add(temp);
				found = true;
			}
		}
		
		if(!found) {
			throw new JobNotFoundException();
		} else {
			return result;
		}
	}
	
	/**
	 * Takes user input and creates a new job then adds it to the list of jobs.
	 */
	public void createJob() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter job position/title:");
		String position = sc.nextLine();
		System.out.println("Please enter company name:");
		String companyName = sc.nextLine();
		
		Job newJob = new Job(position, companyName);
		
		System.out.println("Job successfully created...");
		jobs.add(newJob);
		System.out.println("Job successfully added...");
	}
	
	/**
	 * TODO Boss update job method
	 */
	public void updateJob() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the job you want to update:");
		//TODO take the id then search for the job (can use a helper search method or built in
		//array list method, then find out what the user wants to update about the job and go to
		//the respective function for it.
	}
	
	/**
	 * This method takes in a job whose status is about to be changed by the user
	 * @param toUpdate: job whose status is to be updated
	 */
	public boolean updateStatus(Job toUpdate) {
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while(!done) {
			System.out.println("Current status: " + toUpdate.getStatus());
			System.out.println("Please select an option to change");
			System.out.println("1. Awaiting reply..."
					+ "\n2. Interview confirmed"
					+ "\n3. Failed"
					+ "\n4. Successful");
			int option = sc.nextInt();
			
			if(option == 1){
				toUpdate.setStatus("Awaiting reply...");
				done = true;
			} else if(option == 2) {
				toUpdate.setStatus("Interview confirmed");
				done = true;
			} else if(option == 3) {
				toUpdate.setStatus("Failed");
				done = true;
			} else if(option == 4) {
				toUpdate.setStatus("Successful");
				done = true;
			}
		}
		
		return done;
	}
	//TODO update company name
	//TODO update position
	
	//TODO delete job
	
	/**
	 * Prints to console the details of all the jobs in the ArrayList
	 * @throws JobNotFoundException
	 */
	public void displayJobs() throws JobNotFoundException {
		Iterator<Job> itr = jobs.iterator();
		Job temp;
		String result = "";
		int count = 1;
		
		while(itr.hasNext()) {
			temp = itr.next();
			result += count + ". " + temp.toString() + "\n";
			count++;
		}
		
		if(result.equals("")) {
			throw new JobNotFoundException();
		} else {
			System.out.println(result);
		}
	}
}