package oreswords.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import oreswords.effects.SwordEffect;

public class LapisEffect extends SwordEffect {

	@Override
	protected void effect(ItemStack sword, EntityLivingBase target, EntityLivingBase self) {
		PotionEffect pE = new PotionEffect(Potion.poison.id, 60, 6);//poison, duration, Amplify
    	if(target.isPotionApplicable(pE))
    	{
    		target.addPotionEffect(pE);
    	}
	}

}
