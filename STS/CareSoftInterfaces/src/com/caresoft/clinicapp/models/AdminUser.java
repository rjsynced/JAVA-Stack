package com.caresoft.clinicapp.models;
import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantAdmin;
import com.caresoft.clinicapp.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
		//... imports class definition...
	    
	    // Inside class:
	    private Integer employeeID;
	    private String role;
	    private ArrayList<String> securityIncidents = new ArrayList<String>(); 
	    
	    // TO DO: Implement a constructor that takes an ID and a role
	    // TO DO: Implement HIPAACompliantUser!
	    // TO DO: Implement HIPAACompliantAdmin!
	    
	    public AdminUser(Integer id, String string) {
	    	super(id);
	    	setEmployeeID(id);
	    	this.role = string;
		}
	    
		public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.id, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }
		
	    public Integer getEmployeeID() {
			return employeeID;
		}
	    
		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}
		
		public String getRole() {
			return role;
		}
		
		public void setRole(String role) {
			this.role = role;
		}
		
		@Override
		public boolean assignPin(int i) {
			if(i >= 100000) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public boolean accessAuthorized(Integer confirmedAuthID) {
			if(employeeID == confirmedAuthID) {
				return true;
			} else {
				this.authIncident();
				return false;
			}
		}
		
		@Override
		public ArrayList<String> reportSecurityIncidents() {
			ArrayList<String> output = new ArrayList<String>();
			for (int i = 0; i < this.securityIncidents.size(); i++) {
				output.add(this.securityIncidents.get(i));
			}
			return output;
		}


	    // TO DO: Setters & Getters

}
