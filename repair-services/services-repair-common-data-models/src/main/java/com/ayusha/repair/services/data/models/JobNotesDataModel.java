package com.ayusha.repair.services.data.models;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Job Notes
 */
public class JobNotesDataModel {
	
	/** id **/
	private int id;
	
	/** job id **/
	private String jobId;
	
	/** notes **/
	private String notes="";
	
	/**
	 * default constructor
	 */
	public JobNotesDataModel() {
		
	}

	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
