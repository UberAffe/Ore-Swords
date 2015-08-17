package oreswords.api;

public class API {

	private static APIBase api = new NoAPI();
	
	public static APIBase getAPI(int maxVersion)
	{
		return api.getAPI(maxVersion);
	}
	
	public static void setAPI(APIBase api)
	{
		API.api = api;
	}
}
