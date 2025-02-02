package com.ayusha.job.inventory.data.models;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Job Notes
 */
public class PartIssuedDataModel {
	
	/** id **/
	private int id;
	
	/** jobid **/
	private String jobId;
	
	/** heading **/
	private String heading;
	
	/** partid **/
	private String partId;
	
	/** media **/
	private int quantity;
	
	/** partid **/
	private String type;
	/** partid **/
	private String issudedOn;
	
	/** partid **/
	private byte[] media;
	
	/**
	 * default constructor
	 */
	public PartIssuedDataModel() {
		
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
	 * @return the heading
	 */
	public String getHeading() {
		return heading;
	}

	/**
	 * @param heading the heading to set
	 */
	public void setHeading(String heading) {
		this.heading = heading;
	}

	/**
	 * @return the partId
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * @param partId the partId to set
	 */
	public void setPartId(String partId) {
		this.partId = partId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	 * @return the issudedOn
	 */
	public String getIssudedOn() {
		return issudedOn;
	}

	/**
	 * @param issudedOn the issudedOn to set
	 */
	public void setIssudedOn(String issudedOn) {
		this.issudedOn = issudedOn;
	}

	/**
	 * @return the media
	 */
	public byte[] getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(byte[] media) {
		this.media = media;
	}
}

