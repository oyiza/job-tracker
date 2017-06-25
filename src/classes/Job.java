package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Job {
	
	public String position; 
	public String companyName;
	public String date;
	//can only be one of four options: awaiting reply, interview confirmed, failed and successful 
	public String status;
	//TODO optional notes about the job?
	
	
	//record the date and time the job class was created and store as string
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static final Date jobDate = new Date();
	
	/**
	 * Constructor for class 'Job'
	 * @param position: name of job title
	 * @param company: name of company
	 */
	public Job(String position, String companyName) {
		this.position = position;
		this.companyName = companyName;
		//this.date = dateFormat.format(date);
		this.date = dateFormat.format(jobDate);
		this.status = "Awaiting reply...";
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
		// TODO this date needs to be initialized only once and
		// remain unchanged. Might need to use Timestamp
	}
	
	public void updateStatus() {
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while(!done) {
			System.out.println("Please select an option to change");
			System.out.println("1. Awaiting reply..."
					+ "\n2. Interview confirmed"
					+ "\n3. Failed"
					+ "\n4. Successful");
			int option = sc.nextInt();
			
			if(option == 1){
				this.status = "Awaiting reply...";
				done = true;
			} else if(option == 2) {
				this.status = "Interview confirmed";
				done = true;
			} else if(option == 3) {
				this.status = "Failed";
				done = true;
			} else if(option == 4) {
				this.status = "Successful";
				done = true;
			}
		}
		
		sc.close();
	}
	
	public String getStatus() {
		return this.status;
	}
	
	/** @return string representation of Job details. */
	//TODO will need fixing because I added new features to Job class
	public String toString() {
		String result = "\n";
		result = "Job Position title: " + this.position + "\nCompany Applied to: " +
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