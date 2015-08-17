package oreswords.api;

public enum APIStatus {

	/*
	 * The API was not properly initialized
	 */
	API_NOT_INITIALIZED,
	/*
	 * The API was properly loaded and this object is ready to go
	 * The newest fully functional API Object was returned.
	 */
	OK,
	/*
	 * The API requested is older but has full functionality
	 * A fully functional if old API Object was returned
	 */
	BACKLEVEL_OK,
	/*
	 * The API requested is older and has limited functionality
	 * A semi-functional API Object was returned
	 */
	BACKLEVEL_LIMITED,
	/*
	 * The API request is no longer supported
	 * A non-functional API Object was returned
	 */
	BACKLEVEL_UNSUPORTED,
	/*
	 * An error occured and no API object was provided
	 */
	ERROR;
	
	/*
	 * Shortcut to check for functional API 
	 */
	public boolean isOK()
	{
		return this == OK || this == BACKLEVEL_OK || this == BACKLEVEL_LIMITED;
	}
}
