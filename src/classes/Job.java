package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Job {
	
	public String position; 
	public String companyName;
	public String date;//only four options: awaiting reply, interview confirmed, failed and successful
	public String status;
	//TODO optional notes about the job?
	
	//record the date and time the job class was created and store as string
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static final Date jobDate = new Date();
	
	//Getting a unique ID for each job class
	static AtomicInteger nextId = new AtomicInteger();
    private int job_id;
	
	/**
	 * Constructor for class 'Job'
	 * @param position: name of job title
	 * @param company: name of company
	 */
	public Job(String position, String companyName) {
		this.position = position;
		this.companyName = companyName;
		//this.date = dateFormat.format(date);
		this.date = dateFormat.format(jobDate);//sets the date to the date and time the object was made
		this.status = "Awaiting reply...";
		job_id = nextId.incrementAndGet();
	}
	
	/** @return current job position/title. */
	public String getPosition() {
		return this.position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	/** @return current company name. */
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/** @return the exact date and time job class was created. */
	public String getDate() {
		return this.date;
	}
	
	public int getJobId() {
		return job_id;
	}

	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	/** @return string representation of Job details. */
	public String toString() {
		String result = "\n";
		result = "Job ID: " + getJobId() + "\nJob Position title: " + getPosition() + "\nCompany Applied to: " +
				getCompanyName() + "\nStatus: " + getStatus() + "\nDate applied: "
				+ getDate();
		
		return result;
	}

	public static void main(String[] args) {

		//testing that the time works. It doesn't work the way I want
		//It should show the time the object was created, at the moment
		//it shows current time whatever that is
		Job x = new Job("Software Developer", "IBM");
		System.out.println("testing date: " + x.getDate());
		System.out.println("\n" + x.toString());
	}
}