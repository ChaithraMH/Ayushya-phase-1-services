package com.ayusha.repair.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name="faulty_items")
public class FaultyItemEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column(name="id")
    private long id; 
	

	/** customerid **/
	@Column(name="job_Id")
	private String job_id="";
	
	/** customerid **/
	@Column(name="part_id")
	private String partId="";
	
	/** customerid **/
	@Column(name="heading")
	private String heading="";
	
	/** customerid **/
	@Column(name="faulty")
	private String faulty="";
	
	@Lob
	/** customerid **/
	@Column(name="media")
	private byte[] media;

	/**
	 * default constructor
	 */
	public FaultyItemEntity() {
		
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