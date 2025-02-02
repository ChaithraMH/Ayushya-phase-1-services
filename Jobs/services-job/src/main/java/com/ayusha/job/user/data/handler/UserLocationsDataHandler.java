package com.ayusha.job.user.data.handler;

import com.ayusha.http.client.ServicesClient;
import com.ayusha.http.client.models.ServiceResponse;
import com.ayusha.http.constants.HTTPConstants;
import com.ayusha.job.data.models.JobDataModel;
import com.ayusha.job.services.constants.JobServiceConstants;
import com.ayusha.json.utils.JSONConverter;
import com.ayusha.services.common.exceptions.ServicesDataException;
import com.ayusha.user.data.models.LocationsUsersDataModel;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
 * 
 * @author Finch
 * Date:01-Aug-2019
 * Job Service Methods
 *
 */
public class UserLocationsDataHandler {
	

	
	/** Logger **/
	private Logger LOG = LogManager.getLogger(UserLocationsDataHandler.class);
	
	/** states data model **/
	private JobDataModel jobDataModel;
	
	/** Services client **/
	private ServicesClient servicesClient = new ServicesClient();
	/** 
	
	
	/**
	 * default constructor
	 */
	public UserLocationsDataHandler() {
		servicesClient = new ServicesClient();
		servicesClient.setBaseURL(ServicesClient.USER_BASE_URL);
	}
	

	
	/**
	 * get ticket data
	 */
	public LocationsUsersDataModel getUsersForLocationId(String locationId) throws ServicesDataException{
		ServiceResponse serviceResponse = null;
		ServicesDataException servicesDataException = null;
		LocationsUsersDataModel locationsUsersDataModel = null;
		String serviceName=JobServiceConstants.GET_USERS_FOR_LOCATIONID_SERVICE_NAME;
		
		serviceName = serviceName.replace("$1", locationId);
		try {
			System.out.println("33333");
			serviceResponse = servicesClient.execute(serviceName,"",HTTPConstants.GET);
			System.out.println("33333aaaaaaaaaaa");

			
			locationsUsersDataModel = ((LocationsUsersDataModel)JSONConverter.convertStringToPOJO(""+serviceResponse.getResponse(),LocationsUsersDataModel.class));
			System.out.println("444444");

			LOG.info("<<USER LOCATIONS "+locationsUsersDataModel);
			if(locationsUsersDataModel!=null && locationsUsersDataModel.getLstUsers()!=null) {
				LOG.info("<<USER LOCATIONS "+locationsUsersDataModel.getLstUsers());
			}
			return locationsUsersDataModel;
		}catch(Exception e) {
			System.out.println("444444EEEEE");

			jobDataModel= new JobDataModel();
			return locationsUsersDataModel;
		}
	}
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		try {
			UserLocationsDataHandler userLocationsDataHandler = new UserLocationsDataHandler();
			userLocationsDataHandler.getUsersForLocationId("560038");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
