package com.ayusha.repair;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* This is the service main application for ticket management app.
* This controls the access to the services
*
* @author  Author1
* @version 1.0
* @since   2019-05-03 
*/
@SpringBootApplication
public class RepairServicesApp {  
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RepairServicesApp.class, args);
    }       
}            