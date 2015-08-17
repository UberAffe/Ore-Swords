package oreswords.api;

import java.util.List;

import net.minecraft.block.Block;
import oreswords.effects.SwordEffect;
import oreswords.items.OreSword;

public interface APIv1 extends APIBase{

	/*
	 * @return the full list of Swords available
	 */
	List<OreSword> getSwords();
	
	/*
	 * 
	 * @return true if the sword was added
	 */
	boolean addSword(String enumName, String name, int hLevel, int mUse, float effic, float damage, int ench, Block cType, SwordEffect effect);
}
