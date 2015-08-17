package apiimpl;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import oreswords.api.API;
import oreswords.api.APIBase;
import oreswords.api.APIStatus;
import oreswords.api.APIv1;
import oreswords.effects.SwordEffect;
import oreswords.items.OreSword;
import oreswords.items.OreSword.SWORDTYPES;
import oreswords.lib.OreSwordEnumHelper;

public class APIimplv1 implements APIv1 {

	private final int version;
	private final APIStatus status;
	
	public APIimplv1(int version, APIStatus status)
	{
		this.version = version;
		this.status = status;
	}
	
	@Override
	public APIBase getAPI(int maxVersion) {
		if(maxVersion == version && status == APIStatus.OK)
			return this;
		else
			return API.getAPI(maxVersion);
	}

	@Override
	public APIStatus getStatus() {
		return status;
	}

	@Override
	public int getVersion() {
		return version;
	}

	@Override
	public List<OreSword> getSwords() {
		List<OreSword> list = Lists.newArrayList();
		for(SWORDTYPES sword : SWORDTYPES.values())
			list.add(sword.getSword());
		return list;
	}

	@Override
	public boolean addSword(String enumName, String name, int hLevel, int mUse, float effic, float damage, int ench,
			Block cType, SwordEffect effect) {
		return (OreSwordEnumHelper.addSwordType(enumName, name, hLevel, mUse, effic, damage, ench, cType, effect) == SWORDTYPES.valueOf(enumName));
	}

}
