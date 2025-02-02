package com.ayusha.general.services.data.model;

import java.util.List;

/**
 * 
 * @author author
 * 10-Aug-1029
 * State data
 *
 */
public class CountryDataModel {
	
	/** id **/
	private int id;
	
	/** state **/
	private String countryCode;
	
	/** name **/
	private String name;
	
	/** state list **/
	private List<StateDataModel> lstStateDataModel;
	
	/**
	 * default constructor
	 */
	public CountryDataModel() {
		
	}
	/**
	 * @return the lstStateDataModel
	 */
	public List<StateDataModel> getLstStateDataModel() {
		return lstStateDataModel;
	}


	/**
	 * @param lstStateDataModel the lstStateDataModel to set
	 */
	public void setLstStateDataModel(List<StateDataModel> lstStateDataModel) {
		this.lstStateDataModel = lstStateDataModel;
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
	 * @return the statecode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param statecode the statecode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
