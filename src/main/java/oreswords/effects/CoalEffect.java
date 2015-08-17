package oreswords.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import oreswords.lib.References;

public class CoalEffect extends SwordEffect{
	
	@Override
	protected void effect(ItemStack sword, EntityLivingBase target, EntityLivingBase self) {
		if((References.RANDOM.nextInt(11) % 3) == 2)
    		target.setFire(3);
	}

}
