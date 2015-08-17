package oreswords.effects;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import oreswords.lib.References;

public class DamageEnhancement{

	public DamageEnhancement() {
		// TODO Auto-generated constructor stub
	}

	@SubscribeEvent
	public void testEvent(LivingHurtEvent event)
	{
		Entity attackSource = event.source.getSourceOfDamage();
		if(attackSource instanceof EntityPlayer)
		{
			ItemStack itemstack = ((EntityPlayer)attackSource).getHeldItem();
			if( itemstack != null && ItemSword.class.isAssignableFrom(itemstack.getItem().getClass()) && itemstack.hasTagCompound())
			{
				NBTTagCompound nbtTags = itemstack.getTagCompound();
				if(nbtTags != null && nbtTags.hasKey(References.ENHANCEMENT))
				{
					System.out.println("using enhanced sword");
					if(nbtTags.getBoolean(References.ENHANCEMENT_ACTIVE))
					{
						double val = nbtTags.getDouble(References.ENHANCEMENT);
						double damage = 0;
						for(int i = 1; i < val;)
						{
							val -= i;
							i *= 2;
							damage++;
						}
						System.out.println("damage added: " + damage);
						event.ammount = event.ammount + (float)damage;
					}
				}
			}
			else
				System.out.println("using sword");
			System.out.println("damage done: " + event.ammount);
		}
	}
}

