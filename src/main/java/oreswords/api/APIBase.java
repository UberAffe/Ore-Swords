package oreswords.api;

public interface APIBase {

	/*
	 * internal use only
	 */
	APIBase getAPI(int maxVersion);
	
	/*
	 * returns the status of this API object
	 */
	APIStatus getStatus();
	
	/*
	 * 
	 */
	int getVersion();
}
