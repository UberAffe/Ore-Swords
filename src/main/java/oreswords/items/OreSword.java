package oreswords.items;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
//import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import oreswords.lib.RefStrings;
import scala.util.Random;

public class OreSword extends ItemSword{
	
	
/*
 * Variables and Enums
 */
	private static double KNOCKBACKFACTOR = 0.9;//base knockback distance
	private static int STRENGTHMULTIPLIER = 3;//multiplier for base distance
	private static Random rand = new Random();
	
	private static HashMap<String, SWORDTYPES> swordMap = new HashMap<String, SWORDTYPES>();
	
	public static enum SWORDTYPES
	{
		COAL("coalsword", 1, 131, 4.0F, 1.0F, 5, Blocks.coal_ore),//oreswords_coalsword
		DIAMOND("diamondsword", 3, 1200, 8.0F, 3.0F, 30, Blocks.diamond_ore),//oreswords_diamondsword
		EMERALD("emeraldsword", 3, 2300, 8.0F, 4.0F, 10, Blocks.emerald_ore),//oreswords_emeraldsword
		GOLD("goldsword", 0, 25, 10.0F, 1.0F, 12, Blocks.gold_ore),//oreswords_goldsword
		IRON("ironsword", 2, 131, 6.0F, 2.0F, 14, Blocks.iron_ore),//oreswords_ironsword
		LAPIS("lapissword", 1, 131, 4.0F, 1.0F, 44, Blocks.lapis_ore),//oreswords_lapissword
		QUARTZ("quartzsword", 3, 131, 8.0F, 3.0F, 10, Blocks.quartz_ore),//oreswords_quartzsword
		REDSTONE("redstonesword", 2, 131, 6.0F, 2.0F, 14, Blocks.redstone_ore);//oreswords_redstonesword		
		
		private String name;
		private ToolMaterial mat;
		private Block cType;
		private OreSword sword;
		private SWORDTYPES(String name, int hLevel, int mUse, float effic, float damage, int ench, Block cType)
		{
			this.name = name;
			this.cType = cType;
			this.mat = EnumHelper.addToolMaterial(name, hLevel, mUse, effic, damage, ench);
		}
		public String getName(){return name;}
		public ToolMaterial getMaterial(){return mat;}
		public Block getCraftingMaterial(){return cType;}
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
		setUnlocalizedName(RefStrings.MODID + "_" + sword.getName());
		setTextureName(RefStrings.MODID + ":" + sword.getName());
		setCreativeTab(CreativeTabs.tabCombat);
		sword.setSword(this);
	}
	
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase self)
    {
        sword.damageItem(1, self);
        SWORDTYPES swordType = swordMap.get(sword.getUnlocalizedName());
        switch (swordType){
        case COAL:
        	if((rand.nextInt(11) % 3) == 2)
        		target.setFire(3);
        	break;
        case REDSTONE:
        	if((rand.nextInt(11) % 3) == 2)
        	{
	        	double vector[] = directionVector(target, self);
	        	for(int i = 0; i < STRENGTHMULTIPLIER; i++)
	        		target.knockBack(target, 0, vector[0], vector[1]);
        	}
        	break;
        case LAPIS:
        	PotionEffect pE = new PotionEffect(Potion.poison.id, 60, 6);//poison, duration, Amplify
        	if(target.isPotionApplicable(pE))
        	{
        		target.addPotionEffect(pE);
        	}
		default:
			break;
        }
        return true;
    }
	
	private double[] directionVector(EntityLivingBase target, EntityLivingBase self)
	{
		double vector[] = new double[2];
		vector[0] = self.posX - target.posX;
		vector[1] = self.posZ - target.posZ;
		double reduceBy = Math.hypot(vector[0], vector[1]);
		vector[0] = (vector[0] /reduceBy) * KNOCKBACKFACTOR;
		vector[1] = (vector[1] /reduceBy) * KNOCKBACKFACTOR;
		return vector;
	}
	
}
