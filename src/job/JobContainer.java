package job;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JobContainer {
	
	//Linked list storing created jobs
	public LinkedList<Job> jobs;
	
	/** Constructor */
	public JobContainer() {
		jobs = new LinkedList<Job>();
	}
	
	/** Return the first element in the linked list if it exists */
	public Job head() throws NoSuchElementException {
		Job head = null;
		try {
			head = jobs.getFirst();
		} catch (NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		return head;
	}
	
	/** Return the last element in the linked list if it exists */
	public Job tail() throws NoSuchElementException {
		Job tail = null;
		try {
			tail = jobs.getLast();
		} catch (NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		return tail;
	}
	
	/** Appends newJob to the end of the list, hence the use of 'addLast' */
	public void addJob(Job newJob) {
		if(newJob == null) {
			System.out.println("No new jobs to add.");
		} else {
			jobs.addLast(newJob);
		}
	}
	/** Appends newly created job to the end of the list */
	public void addJob(String position, String company) {
		// if(position == null || company == null)
		Job x = new Job(position, company);
		jobs.addLast(x);
	}
	
	/** Deletes the specified job from the list */
	public boolean deleteJob(Job currJob) {
		boolean done = false;
		
		if(currJob == null) {
			System.out.println("No job to selected.");
			return done;
		} else {
			jobs.remove(currJob);
			return done;
		}
	}
	
	public String toString() {
		// TODO Test this
		return jobs.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
