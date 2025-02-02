package com.ayusha.repair.services.data.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author author
 * 08-Aug-2019
 * Symptoms details
 *
 */
public class SymptomsDataModel {
	
	/** id **/
	private int id;
	
	/** jobid **/
	private String job_id;
	
	/** symptoms **/
	private List<SymptomDataModel> lstSymptoms = new ArrayList();
	
	/**
	 * default constructor
	 */
	public SymptomsDataModel() {
		
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
	 * @return the lstSymptoms
	 */
	public List<SymptomDataModel> getLstSymptoms() {
		return lstSymptoms;
	}

	/**
	 * @param lstSymptoms the lstSymptoms to set
	 */
	public void setLstSymptoms(List<SymptomDataModel> lstSymptoms) {
		this.lstSymptoms = lstSymptoms;
	}
}
