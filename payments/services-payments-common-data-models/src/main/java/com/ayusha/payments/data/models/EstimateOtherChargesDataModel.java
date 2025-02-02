package com.ayusha.payments.data.models;

/**
 * 
 * @author author
 * 10-Aug-2019
 *
 */
public class EstimateOtherChargesDataModel {
	
	/** id **/
	private int id;
	
	/** cash receipt id **/
	private String estimateId;
	
	/** cash receipt id **/
	private String type;
	
	/** cash receipt id **/
	private double amount;
	

	
	
	/**
	 * default constructor
	 */
	public EstimateOtherChargesDataModel() {
		
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
	 * @return the estimateId
	 */
	public String getEstimateId() {
		return estimateId;
	}




	/**
	 * @param estimateId the estimateId to set
	 */
	public void setEstimateId(String estimateId) {
		this.estimateId = estimateId;
	}




	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
