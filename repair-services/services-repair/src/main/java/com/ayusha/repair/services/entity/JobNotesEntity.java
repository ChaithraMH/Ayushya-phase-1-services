package com.ayusha.repair.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Ticket Model
 *
 */
@Entity
@Table(name="job_notes")
public class JobNotesEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column(name="id")
    private long id; 
	

	/** customerid **/
	@Column(name="job_Id")
	private String job_id="";
	
	/** customerid **/
	@Column(name="notes")
	private String notes="";

	/**
	 * default constructor
	 */
	public JobNotesEntity() {
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the job_id
	 */
	public String getJob_id() {
		return job_id;
	}

	/**
	 * @param job_id the job_id to set
	 */
	public void setJob_id(String job_id) {
		this.job_id = job_id;
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
}