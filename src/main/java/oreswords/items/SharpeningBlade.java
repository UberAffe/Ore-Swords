package oreswords.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oreswords.lib.RefStrings;

public class SharpeningBlade extends Item{

	public SharpeningBlade()
	{
		setUnlocalizedName(RefStrings.MODID + "_" + "sharpeningblade");
		setTextureName(RefStrings.MODID + ":" + "sharpeningblade");
		setCreativeTab(CreativeTabs.tabTools);
	}
}
