package com.ayusha.repair.services.constants;

/**
 * 
 * @author author
 * 08-Aug-2019
 * Repai services constants
 *
 */
public class RepairServiceConstants {

	
	/** Job Notes Get Service Name **/
	public final static String GET_JOB_NOTES_SERVICE_NAME="repairs/notes/find?jobid=$1";
	/** Job Notes Get Service Name **/
	public final static String UPDATE_JOB_NOTES_SERVICE_NAME="repairs/notes/update/";
	
	/** Job Notes Get Service Name **/
	public final static String GET_REPAIR_SYMPTOMS_SERVICE_NAME="repairs/symptoms/find?jobid=$1";
	/** Job Notes Get Service Name **/
	public final static String UPDATE_REPAIR_SYMPTOMS_SERVICE_NAME="repairs/symptoms/add/";
	
	/** Job Notes Get Service Name **/
	public final static String GET_REPAIR_FAULTY_ITEMS_SERVICE_NAME="repairs/faultyitems/find?jobid=$1";
	/** Job Notes Get Service Name **/
	public final static String UPDATE_REPAIR_FAULTY_ITEMS_SERVICE_NAME="repairs/faultyitems/add";
	
}
