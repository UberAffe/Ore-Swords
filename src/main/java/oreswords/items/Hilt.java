package oreswords.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oreswords.lib.References;

public class Hilt extends Item{
	
	public Hilt()
	{
		setUnlocalizedName(References.MODID + "_" + "hilt");
		setTextureName(References.MODID + ":" + "hilt");
		setCreativeTab(CreativeTabs.tabTools);
	}

}
