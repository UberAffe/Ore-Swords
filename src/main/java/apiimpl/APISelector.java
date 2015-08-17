package apiimpl;

import oreswords.api.API;
import oreswords.api.APIBase;
import oreswords.api.APIStatus;

public class APISelector implements APIBase{

	private APISelector(){}
	
	public static void init()
	{
		API.setAPI(new APISelector());
	}
	
	@Override
	public APIBase getAPI(int maxVersion) {
		if(maxVersion <= 0)
			return this;
		else
			return new APIimplv1(1, APIStatus.OK);
	}

	@Override
	public APIStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return -1;
	}

}
