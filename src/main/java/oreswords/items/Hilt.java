package oreswords.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oreswords.lib.RefStrings;

public class Hilt extends Item{
	
	public Hilt()
	{
		setUnlocalizedName(RefStrings.MODID + "_" + "hilt");
		setTextureName(RefStrings.MODID + ":" + "hilt");
		setCreativeTab(CreativeTabs.tabTools);
	}

}
