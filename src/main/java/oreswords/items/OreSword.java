package oreswords.items;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import oreswords.effects.CoalEffect;
import oreswords.effects.RedstoneEffect;
import oreswords.effects.SwordEffect;
import oreswords.lib.References;

public class OreSword extends ItemSword{
	
/*
 * Variables and Enums
 */
	
	private static HashMap<String, SWORDTYPES> swordMap = new HashMap<String, SWORDTYPES>();
	
	public static enum SWORDTYPES
	{
		COAL("coalsword", 1, 131, 4.0F, 1.0F, 5, Blocks.coal_ore, new CoalEffect()),//oreswords_coalsword
		DIAMOND("diamondsword", 3, 1200, 8.0F, 3.0F, 30, Blocks.diamond_ore, null),//oreswords_diamondsword
		EMERALD("emeraldsword", 3, 2300, 8.0F, 4.0F, 10, Blocks.emerald_ore, null),//oreswords_emeraldsword
		GOLD("goldsword", 0, 25, 10.0F, 1.0F, 12, Blocks.gold_ore, null),//oreswords_goldsword
		IRON("ironsword", 2, 131, 6.0F, 2.0F, 14, Blocks.iron_ore, null),//oreswords_ironsword
		LAPIS("lapissword", 1, 131, 4.0F, 1.0F, 44, Blocks.lapis_ore, new LapisEffect()),//oreswords_lapissword
		QUARTZ("quartzsword", 3, 131, 8.0F, 3.0F, 10, Blocks.quartz_ore, null),//oreswords_quartzsword
		REDSTONE("redstonesword", 2, 131, 6.0F, 2.0F, 14, Blocks.redstone_ore, new RedstoneEffect());//oreswords_redstonesword		
		
		private String name;
		private ToolMaterial mat;
		private Block cType;
		private OreSword sword;
		private SwordEffect effect;
		SWORDTYPES(String name, int hLevel, int mUse, float effic, float damage, int ench, Block cType, SwordEffect effect)
		{
			this.name = name;
			this.cType = cType;
			this.mat = EnumHelper.addToolMaterial(name, hLevel, mUse, effic, damage, ench);
			this.effect = effect;
		}
		public String getName(){return name;}
		public ToolMaterial getMaterial(){return mat;}
		public Block getCraftingMaterial(){return cType;}
		public void doEffect(ItemStack sword, EntityLivingBase target, EntityLivingBase self){effect.doEffect(sword, target, self);}
		public void setSword(OreSword sword)
		{
			this.sword = sword;
			swordMap.put(sword.getUnlocalizedName(), this);
			
		}
		public OreSword getSword(){return sword;}
	}
	
	
	/*
	 * Methods
	 */
	
	public OreSword(SWORDTYPES sword)
	{
		super(sword.getMaterial());
		setUnlocalizedName(References.MODID + "_" + sword.getName());
		setTextureName(References.MODID + ":" + sword.getName());
		setCreativeTab(CreativeTabs.tabCombat);
		sword.setSword(this);
	}
	
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase self)
    {
        sword.damageItem(1, self);
        SWORDTYPES swordType = swordMap.get(sword.getUnlocalizedName());
        swordType.doEffect(sword, target, self);
        return true;
    }	
}
