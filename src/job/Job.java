package job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Job {
	
	public String title, companyName;
	public String date;
	public String status;
	
	//record the date and time the job class was created and store as string
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date jobDate = new Date();
	
	/**
	 * Constructor for class 'Job'
	 * @param position: name of job title
	 * @param company: name of company
	 */
	public Job (String position, String company) {
		this.title = position;
		this.companyName = company;
		//this.date = dateFormat.format(date);
		this.date = dateFormat.format(jobDate);
		this.status = "Awaiting reply...";
	}
	
	/** @return current job title. */
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	/** @return current company name. */
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setCompanyName(String newCompanyName) {
		this.companyName = newCompanyName;
	}
	
	/** @return the exact date and time job class was created. */
	public String getDate() {
		return this.date;
		// TODO this date needs to be initialized only once and
		// remain unchanged. Might need to use Timestamp
	}
	
	public void updateStatus(String newStatus) {
		this.status = newStatus;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	/** @return string representation of Job details. */
	public String toString() {
		String result = "\n";
		result = "Job title: " + this.title + "\nCompany Applied to: " +
				this.companyName + "\nStatus: " + this.status + "\nDate applied: "
				+ this.date;
		
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
