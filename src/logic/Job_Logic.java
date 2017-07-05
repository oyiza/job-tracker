package logic;

import classes.Job;
import exception.JobNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Job_Logic {
	
	//List of jobs that the system keeps track of
	ArrayList<Job> jobs = new ArrayList<Job>();
	
	/**
	 * TODO Boss search method
	 */
	public void searchJob() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Job> temp = new ArrayList<Job>();
		System.out.println("How would you like to search?\n1 - By Position\n2 - By Company Name"
				+ "\n3 - By Status");
		int option = sc.nextInt();
		
		//maybe close scanner here and open a new one inside the switch block?
		//or maybe because i'm iterating through the temp list?
		
		switch(option) {
		//By position
		case 1:
			System.out.println("Please enter position:");
			System.out.println(sc.next());
			String position = sc.nextLine(); //TODO new issue!! this line reads position as "" and
			//doesn't store user input
			System.out.println("Position is: " + position);
			try{
				temp = searchJobByPosition(position);
			} catch(JobNotFoundException e) {
				System.out.println(e);
			}
			break;
		//By Company name
		case 2:
			break;
		//By Status
		case 3:
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
	public ArrayList<Job> searchJobByPosition(String position)  throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getPosition().equalsIgnoreCase(position)) {
				result.add(temp);
			}
		}
		
		if(temp == null) {
			throw new JobNotFoundException();
		}
		
		return result;
	}
	
	/**
	 * Search method to return jobs by specific company name
	 * @return an ArrayList containing all jobs with company name as companyName 
	 * @throws JobNotFoundException
	 */
	public ArrayList<Job> searchJobByCompanyName(String companyName) throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getCompanyName().equalsIgnoreCase(companyName)) {
				result.add(temp);
			}
		}
		
		if(temp == null) {
			throw new JobNotFoundException();
		}
		
		return result;
	}
	
	/**
	 * Search method to return jobs by specific status
	 * @return an ArrayList containing all jobs with specified status
	 * @throws JobNotFoundException
	 */
	public ArrayList<Job> searchJobByStatus(String status) throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getStatus().equalsIgnoreCase(status)) {
				result.add(temp);
			}
		}
		
		if(temp == null) {
			throw new JobNotFoundException();
		}
		
		return result;
	}
	
	/**
	 * Dynamically takes user input and creates a new job then adds it to the list of jobs.
	 */
	public void createJob() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter job position/title:");
		String position = sc.nextLine();
		System.out.println("Please enter company name:");
		String companyName = sc.nextLine();
		
		Job newJob = new Job(position, companyName);
		jobs.add(newJob);
	}
	
	/**
	 * TODO Boss update job method
	 */
	//TODO update status
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