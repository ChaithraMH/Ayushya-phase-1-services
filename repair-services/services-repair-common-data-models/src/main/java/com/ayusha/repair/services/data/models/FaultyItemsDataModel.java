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
public class FaultyItemsDataModel {

	/** id **/
	private int id;
	
	/** jobid **/
	private String job_id;
	
	/** symptoms **/
	private List<FaultyItemDataModel> lstFaultyItems = new ArrayList();
	
	/**
	 * default constructor
	 */
	public FaultyItemsDataModel() {
		
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
	 * @return the lstFaultyItems
	 */
	public List<FaultyItemDataModel> getLstFaultyItems() {
		return lstFaultyItems;
	}

	/**
	 * @param lstFaultyItems the lstFaultyItems to set
	 */
	public void setLstFaultyItems(List<FaultyItemDataModel> lstFaultyItems) {
		this.lstFaultyItems = lstFaultyItems;
	}
}
