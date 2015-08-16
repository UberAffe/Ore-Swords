package oreswords.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import oreswords.lib.RefStrings;

public class TileEntitySharpeningBlock extends TileEntity{
	
	public TileEntitySharpeningBlock()
	{
		super();
		blockMetadata = 0;
	}
	
	public boolean processInteraction(EntityPlayer player)
	{
		if(player.inventory.getCurrentItem() != null)
		{
			ItemStack heldStack = player.getHeldItem();
			System.out.println(heldStack.getItem().getClass().toString());
			try{
				if(ItemSword.class.isAssignableFrom(heldStack.getItem().getClass()) && blockMetadata > 0)
				{
					System.out.println("points added");
					NBTTagCompound setNBT = new NBTTagCompound();
					if(heldStack.hasTagCompound())
						setNBT = heldStack.getTagCompound();
					if(setNBT.hasKey(RefStrings.ENHANCEMENT))
						setNBT.setInteger(RefStrings.ENHANCEMENT, setNBT.getInteger(RefStrings.ENHANCEMENT) + 1);
					else
						setNBT.setInteger(RefStrings.ENHANCEMENT, 1);
					setNBT.setBoolean(RefStrings.ENHANCEMENT_ACTIVE, true);
					System.out.println("points = " + setNBT.getDouble(RefStrings.ENHANCEMENT));
					heldStack.setTagCompound(setNBT);
					blockMetadata--;
					System.out.println("Uses left: " + blockMetadata);
					if(blockMetadata == 0)
					{
						markDirty();
						worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					}
					return true;
				}
				else if(heldStack.getItem() instanceof SharpeningBlade)
				{
					if(blockMetadata == 0)
					{
						blockMetadata = 10;
						markDirty();
						worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					}
					System.out.println("Uses left: " + blockMetadata);
					heldStack.setItemDamage(1);
					return true;
				}
				return false;
			}
			catch(Exception ex){
				System.out.println("something happened");
				System.out.println(ex.getMessage());
				System.out.println("something happened");
			}	
		}
		return false;
	}
}
