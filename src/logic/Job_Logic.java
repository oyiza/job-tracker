package logic;

import classes.Job;
import exception.JobNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Job_Logic {
	
	//List of jobs that the system keeps track of
	ArrayList<Job> jobs = new ArrayList<Job>();
	
	
	//TODO I keep getting a null when i delete a job and try to access it. I need to properly throw
	//job exception and catch it and print out the message
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
			String one = "Awaiting reply...";
			String two = "Interview Confirmed";
			String three = "Failed";
			String four = "Successful";
			System.out.println("Please select a status:\n1: " + one + "\n2: " + two + "\n3: " + three
					+ "\n4: " + four);
			int status = sc.nextInt();
			
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
	private ArrayList<Job> searchJobByStatus(int status_id) throws JobNotFoundException {
		ArrayList<Job> result = new ArrayList<Job>();
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		boolean found = false;
		String status = null;
		
		if(status_id == 1) {
			status = "Awaiting reply...";
		} else if(status_id == 2) {
			status = "Interview Confirmed";
		} else if(status_id == 3) {
			status = "Failed";
		} else if(status_id == 4) {
			status = "Successful";
		} else {
			System.out.println("Error: somehow ID is not between 1 and 4");
		}
		
		while(itr.hasNext() && !status.equals(null)) {
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
	 * Boss updateJob() method that determines what the user wants to update about a specific job
	 * @throws JobNotFoundException 
	 */
	public void updateJob() throws JobNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the job you want to update:");
		int id = sc.nextInt();
		Job temp = searchJobByID(id);
		
		System.out.println("Printing out job details:...");
		System.out.println(temp.toString());
		System.out.println("\nWhat do you want to update?\n1: Status \n2: Company Name \n3: Position");
		int option = sc.nextInt();
		
		switch(option) {
		//Status
		case 1:
			if(updateStatus(temp)) {
				System.out.println("Status updated successfully\n");
			} else {
				System.out.println("Oops!!!! Status not updated. Something went wrong!\n");
			}
			break;
		//Company Name
		case 2:
			if(updateCompanyName(temp)) {
				System.out.println("Company name updated successfully\n");
			} else {
				System.out.println("Oops!!!! Company name not updated. Something went wrong!\n");
			}
			break;
		//Position
		case 3:
			if(updatePosition(temp)) {
				System.out.println("Position updated succesfully\n");
			} else {
				System.out.println("Oops!!!! Position not updated. Something went wrong!\n");
			}
			break;
		}
	}
	
	/**
	 * Helper function to search for job with given id
	 * @param id: of job to look for
	 * @return found job
	 * @throws JobNotFoundException
	 */
	private Job searchJobByID(int id) throws JobNotFoundException {
		Iterator<Job> itr = jobs.iterator();
		Job temp = null;
		boolean found = false;
		
		while(itr.hasNext() && !found) {
			temp = itr.next();
			if(temp.getJobId() == id) {
				found = true;
			}
		}
		
		if(!found) {
			throw new JobNotFoundException();
		} else {
			return temp;
		}
	}
	
	/**
	 * This method updates a job's status to the choice of the user
	 * @param toUpdate: job whose status is to be updated
	 */
	private boolean updateStatus(Job toUpdate) {
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
				} else {
					System.out.println("Please enter a valid option (1-4)");
				}
		}
		
		return done;
	}
	
	/**
	 * Updates the job's company name to whatever the user decides
	 * @param toUpdate: the job
	 * @return true
	 */
	private boolean updateCompanyName(Job toUpdate) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Current company name: " + toUpdate.getCompanyName());
		System.out.println("Please enter new Company name:");
		String newCompanyName = sc.nextLine();
		toUpdate.setCompanyName(newCompanyName);;
		return true;
	}
	
	/**
	 * Updates the job's position/title to whatever the user decides
	 * @param toUpdate: the job
	 * @return true
	 */
	private boolean updatePosition(Job toUpdate) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Current position: " + toUpdate.getPosition());
		System.out.println("Please enter the new position/title");
		String newPosition = sc.nextLine();
		toUpdate.setPosition(newPosition);
		return true;
	}
	
	/**
	 * Deletes job specified by job id
	 * @throws JobNotFoundException
	 */
	public void deleteJob() throws JobNotFoundException {
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		
		System.out.println("Please enter the id of the job you want to delete");
		int id = sc.nextInt();
		Job temp = searchJobByID(id);
		System.out.println("\n" + temp.toString());
		System.out.println();
		System.out.println("Press 1 to delete and 2 to cancel");
		int option = sc.nextInt();
		
		while(!done){
			if(option == 1) {
				System.out.println("Are you sure you want to delete this job?\n1 - Yes\n2 - No");
				int finalOption = sc.nextInt();
				if(finalOption == 1) {
					jobs.remove(temp);
					done = true;
					System.out.println("Job deleted successfully!!\n\n");
				} else if(finalOption == 2) {
					done = true;
					break;
				}
			} else if(option == 2) {
				done = true;
				break;
			} else {
				System.out.println("Please enter a valid option");
			}
		}
	}
	
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