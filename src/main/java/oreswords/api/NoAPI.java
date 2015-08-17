package oreswords.api;


/*
 * Filler object until Ore Swords has been intialized
 */
public class NoAPI implements APIBase {

	@Override
	public APIBase getAPI(int maxVersion) {
		return this;
	}

	@Override
	public APIStatus getStatus() {
		return APIStatus.API_NOT_INITIALIZED;
	}

	@Override
	public int getVersion() {
		return -1;
	}

}
