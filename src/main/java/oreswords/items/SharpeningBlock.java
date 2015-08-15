package oreswords.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import oreswords.lib.RefStrings;

public class SharpeningBlock extends BlockContainer{

	private static final String name = "sharpeningblock";
	private static final Material mat = Material.rock;
	private int metaData = 0;
	private IIcon[] icons;
	
	public SharpeningBlock() {
		super(mat);
		setBlockName(RefStrings.MODID + "_" + name);
		setBlockTextureName(RefStrings.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iReg)
	{
		icons = new IIcon[4];
		for(int i = 0; i < icons.length; i++)
			icons[i] = iReg.registerIcon(this.textureName + "_" + i);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int face, int mdata )
	{
		if(face == 1 && metaData > 0)
			return icons[1];// bladed top
		else if(face == 1 && metaData == 0)
			return icons[2];//bladeless top
		else if(face == 0)
			return icons[0];//bottom
		return icons[3];//sides
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return metaData;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		
        System.out.println("block activated");
		if(world.isRemote)
		{
			System.out.println("world is remote");
			TileEntity self = world.getTileEntity(x, y, z);
			if(self != null && self instanceof TileEntitySharpeningBlock)
			{
				((TileEntitySharpeningBlock) self).processInteraction(player);
			}
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item , 1, 0));
        list.add(new ItemStack(item , 1, 10));
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySharpeningBlock();
	}
	
}