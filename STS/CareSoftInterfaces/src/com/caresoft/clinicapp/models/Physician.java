package com.caresoft.clinicapp.models;
import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {
		//... imports class definition...
	    
	    // Inside class:    
	    private ArrayList<String> patientNotes;
		
	    // TO DO: Constructor that takes an ID
	    // TO DO: Implement HIPAACompliantUser!
		
	    public Physician(Integer id) {
			super(id);
		}

		public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }

	    // TO DO: Setters & Getters
		public ArrayList<String> getPatientNotes() {
			return patientNotes;
		}

		public void setPatientNotes(ArrayList<String> patientNotes) {
			this.patientNotes = patientNotes;
		}

		public boolean assignPin(int i) {
			if(i >= 1000 && i < 10000) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public boolean accessAuthorized(Integer confirmedAuthID) {
			if(super.id == confirmedAuthID) {
				return true;
			}
			return false;
		}
		
}
