package oreswords.api;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public abstract class SwordApi extends Item{

	protected static final Random rand = new Random();
	
	@Override
	/*
	 * Overrideing this method allows you to add specially on hit effects like the Coal Sword does.
	 */
	public abstract boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase self);
	
	/*
	 * chance can be (0-1]
	 *  it represents your chance as a percent of returning true
	 * spread can be (0, Integer.Max]
	 *  represents how many hits to spread the chance across
	 *  
	 *  chance=.3, spread=10
	 *  across every 10 hits you will have 3 trues returned
	 *  can be up to 7 hits in a row with no effect and
	 *  up to 3 consecutive trues returned
	 *  chance=.6, spread=100
	 *  across every 100 hits you will have 60 trues returned
	 *  can be up to 40 hits in a row with no effect and
	 *  up to 60 consecutive trues returned
	 */
	protected boolean getChance(double chance, int spread)
	{
		spread = (spread < 1) ? 10 : spread * 10;
		return (rand.nextInt(spread) == Math.floor((double)spread * 
				((chance > 1) ? 1 : (chance < 0) ? 0.01 : chance))) ? true : false;
	}
}
