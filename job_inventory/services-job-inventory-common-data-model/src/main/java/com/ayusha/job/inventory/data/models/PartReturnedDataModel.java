package com.ayusha.job.inventory.data.models;

/**
 * 
 * @author author1 Date : 01-Aug-2019 Job Notes
 */
public class PartReturnedDataModel {

	/** id **/
	private int id;

	/** jobid **/
	private String jobId;

	/** heading **/
	private String heading;

	/** partid **/
	private String partId;

	/** quantity **/
	private int quantity;

	/** type **/
	private String type;
	/** returnedOn **/
	private String returnedOn;
	/** remarks **/
	private String remarks;

	/** media **/
	private byte[] media;

	/**
	 * default constructor
	 */
	public PartReturnedDataModel() {

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
	public String getReturnedOn() {
		return returnedOn;
	}

	/**
	 * @param issudedOn the issudedOn to set
	 */
	public void setReturnedOn(String returnedOn) {
		this.returnedOn = returnedOn;
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

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
