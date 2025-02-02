package com.ayusha.communication.data.models;

/**
 * 
 * @author Author
 * Date:01-Aug-2019
 * Communication Data Model class
 *
 */

public class NotificationDataModel {
	
	/** id **/
	private int id;
	
	/** channeltype**/
	private String channelType;
	
	
	/** notificationType**/
	private String notificationType;
	
	/**requestedOn**/
	private String requestedOn;
	
	/**status **/
	private String status;
	
	/**notifiedOn **/
	private String notifiedOn;
	
	/**appId**/
	private String appId;
	
	/** requestedBy**/
	private String requestedBy;
	
	/**remarks**/
	private String remarks;
	
	/**notificationId**/
	private String notificationId;
	
	/**
	 * default constructor
	 */
	public NotificationDataModel() {
		
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
	 * @return the notificationId
	 */
	public String getNotificationId() {
		return notificationId;
	}

	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * @return the channelType
	 */
	public String getChannelType() {
		return channelType;
	}

	/**
	 * @param channelType the channelType to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	/**
	 * @return the notificationType
	 */
	public String getNotificationType() {
		return notificationType;
	}

	/**
	 * @param notificationType the notificationType to set
	 */
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * @return the requestedOn
	 */
	public String getRequestedOn() {
		return requestedOn;
	}

	/**
	 * @param requestedOn the requestedOn to set
	 */
	public void setRequestedOn(String requestedOn) {
		this.requestedOn = requestedOn;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the notifiedOn
	 */
	public String getNotifiedOn() {
		return notifiedOn;
	}

	/**
	 * @param notifiedOn the notifiedOn to set
	 */
	public void setNotifiedOn(String notifiedOn) {
		this.notifiedOn = notifiedOn;
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the requestedBy
	 */
	public String getRequestedBy() {
		return requestedBy;
	}

	/**
	 * @param requestedBy the requestedBy to set
	 */
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
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
