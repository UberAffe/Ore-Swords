package oreswords.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
//import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import oreswords.lib.RefStrings;

public class OreSword extends ItemSword{
	
	public OreSword(SWORDTYPES sword)
	{
		super(sword.getMaterial());
		setUnlocalizedName(RefStrings.MODID + "_" + sword.getName());
		setTextureName(RefStrings.MODID + ":" + sword.getName());
		//setCreativeTab(CreativeTabs.tabCombat);
		sword.setSword(this);
	}
	
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase self)
    {
        sword.damageItem(1, self);
        if(sword.getUnlocalizedName().equals(SWORDTYPES.COAL.getSword().getUnlocalizedName()))
        	target.setFire(100);
        else if(sword.getUnlocalizedName().equals(SWORDTYPES.REDSTONE.getSword().getUnlocalizedName()))
        	target.knockBack(target, 0, 10, 10);
        System.out.println(sword.getUnlocalizedName());
        return true;
    }
	
	public static enum SWORDTYPES
	{
		COAL("coalsword", 1, 131, 4.0F, 1.0F, 5),
		DIAMOND("diamondsword", 3, 1200, 8.0F, 3.0F, 30),
		EMERALD("emeraldsword", 3, 2300, 8.0F, 4.0F, 10),
		GOLD("goldsword", 0, 25, 10.0F, 1.0F, 12),
		IRON("ironsword", 2, 131, 6.0F, 2.0F, 14),
		LAPIS("lapissword", 1, 131, 4.0F, 1.0F, 44),
		QUARTZ("quartzsword", 3, 131, 8.0F, 3.0F, 10),
		REDSTONE("redstonesword", 2, 131, 6.0F, 2.0F, 14);
		
		private String name;
		/*private int hLevel;
		private int mUse;
		private float effic;
		private float damage;
		private int ench;*/
		private ToolMaterial mat;
		private OreSword sword;
		private SWORDTYPES(String name, int hLevel, int mUse, float effic, float damage, int ench)
		{
			this.name = name;
			this.mat = EnumHelper.addToolMaterial(name, hLevel, mUse, effic, damage, ench);
		}
		public String getName(){return name;}
		public ToolMaterial getMaterial(){return mat;}
		public void setSword(OreSword sword){this.sword = sword;}
		public OreSword getSword(){return sword;}
	}

}
