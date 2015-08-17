package oreswords.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import oreswords.lib.References;

public class SharpeningBlade extends Item{

	public SharpeningBlade()
	{
		setUnlocalizedName(References.MODID + "_" + "sharpeningblade");
		setTextureName(References.MODID + ":" + "sharpeningblade");
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(itemstack.getItemDamage() == 1)
		{
			player.setCurrentItemOrArmor(0, null);
			return true;
		}
		return false;	
	}
}
