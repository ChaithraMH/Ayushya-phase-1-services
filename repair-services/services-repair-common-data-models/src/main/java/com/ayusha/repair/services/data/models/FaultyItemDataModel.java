package com.ayusha.repair.services.data.models;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Job Notes
 */
public class FaultyItemDataModel {
	
	/** id **/
	private int id;
	
	/** jobid **/
	private String jobId;
	
	/** heading **/
	private String heading;
	
	/** partid **/
	private String partId;
	
	/** media **/
	private byte[] media;
	
	/** partid **/
	private String faulty;
	
	/**
	 * default constructor
	 */
	public FaultyItemDataModel() {
		
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
	 * @return the faulty
	 */
	public String getFaulty() {
		return faulty;
	}

	/**
	 * @param faulty the faulty to set
	 */
	public void setFaulty(String faulty) {
		this.faulty = faulty;
	}
}
