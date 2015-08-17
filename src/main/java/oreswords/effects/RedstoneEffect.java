package oreswords.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import oreswords.lib.References;

public class RedstoneEffect extends SwordEffect{

	private static int STRENGTHMULTIPLIER = 3;//multiplier for base distance
	private static double KNOCKBACKFACTOR = 0.9;//base knockback distance
	
	@Override
	protected void effect(ItemStack sword, EntityLivingBase target, EntityLivingBase self) {
		if((References.RANDOM.nextInt(11) % 3) == 2)
    	{
        	double vector[] = directionVector(target, self);
        	for(int i = 0; i < STRENGTHMULTIPLIER; i++)
        		target.knockBack(target, 0, vector[0], vector[1]);
    	}
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
