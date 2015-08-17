package oreswords.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public abstract class SwordEffect {

	public void doEffect(ItemStack sword, EntityLivingBase target, EntityLivingBase self){effect(sword, target, self);}
	
	protected abstract void effect(ItemStack sword, EntityLivingBase target, EntityLivingBase self);
}
