package logic;

import classes.Job;
import exception.JobNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;

public class Job_Logic {
	
	//List of jobs that the system keeps track of
	ArrayList<Job> jobs = new ArrayList<Job>();
	
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
}