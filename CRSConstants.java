package org.muqit.carrentalsystem.constants;

public class CRSConstants 
{
	public static final String adminUserId = "admin";
	public static final String adminPassword = "admin";
	
	public static final String messageInvalidUserName = "Invalid User Name, Please try Again";
	public static final String messageInvalidCredentials = "Invalid Crendentials, Please try Again";
	public static final String messageFailedToProcess = "We failed to process your request, Please try again";
	public static final String messageAddAnother = "addded Sucessfully, Add another";
	public static final String messageNameExists = "Already Exists";
	public static final String messageRemovedSuccessfully = "Removed Successfully";
	public static final String messageLimitReached = "Limit Reached";
	public static final String messageInvalidData = "Invalid data found, please try again";
	public static final String messageUpdatedSuccessfully = "Updated Successfully";
	
	public static final String projectName="CarRentalSystem";
	
	public static final int success = 1;
	public static final int exceptionOccured = 0;
	public static final int invalidData = 2;
	public static final int notExists = 3;
	
	public static final int STATUS_ACTIVE = 1;
	public static final int STATUS_DELETED = 0;
	public static final int STATUS_BLOCKED = 2;
	
	public static final int STATUS_NOT_BOOKED=0;
	public static final int STATUS_BOOKED=1;
	public static final int STATUS_NOT_USABLE=0;
	public static final int STATUS_USABLE=1;
	
	//View Names // here
	public static final String loginViewName= "Login";
}
