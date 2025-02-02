package com.ayusha.products.service.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/**
 * 
 * @author Finch
 * Date:01-Aug-2019
 * Product and supported service types
 *
 */

@Entity
@Table(name="symptoms")
public class SymptomEntity {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	
	/**id**/
	@Column(name="id")
    private long id; 
	

	/**symptom  **/
	@Column(name="symptom")
	private String symptom="";
	
	/** description **/
	@Column(name="description")
	private String description="";
	
	/** symptomId **/
	@Column(name="symptom_id")
	private String symptomId="";
	
	/**
	 * default constructor
	 */
	public SymptomEntity() {
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the symptomId
	 */
	public String getSymptomId() {
		return symptomId;
	}

	/**
	 * @param symptomId the symptomId to set
	 */
	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getSymptom() {
		return symptom;
	}

	/**
	 * @param name the name to set
	 */
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
