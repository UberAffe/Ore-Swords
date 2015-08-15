package oreswords.oreswords;

import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import oreswords.effects.DamageEnhancement;
import oreswords.items.Hilt;
import oreswords.items.OreSword;
import oreswords.items.OreSword.SWORDTYPES;
import oreswords.items.SharpeningBlade;
import oreswords.items.SharpeningBlock;
import oreswords.lib.RefStrings;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION, useMetadata = true)
public class OreSwords {
	
	@Instance(RefStrings.MODID)
    public static OreSwords instance;

	//@SidedProxy(clientSide = RefStrings.CLIENTPROXY, serverSide = RefStrings.SERVERPROXY)
    //public static CommonProxy proxy;	
	
	public static DamageEnhancement evHandler = new DamageEnhancement();
	
	public static Item hilt = new Hilt();
	public static Item sharpeningblade = new SharpeningBlade();
	public static Block sharpeningblock = new SharpeningBlock();
	
	@EventHandler
    public void preInit (FMLPreInitializationEvent event){
        // preinit
		for(SWORDTYPES sword : SWORDTYPES.values())
			GameRegistry.registerItem(new OreSword(sword), RefStrings.MODID + "_" + sword.getName());
		GameRegistry.registerItem(hilt, RefStrings.MODID + "_" + "hilt");
		GameRegistry.registerItem(sharpeningblade, RefStrings.MODID + "_" + "sharpeningblade");
		GameRegistry.registerBlock(sharpeningblock, RefStrings.MODID + "_" + "sharpeningblock");
    }
	
	@EventHandler
    public void init (FMLInitializationEvent event){
        // init
		GameRegistry.addRecipe(new ItemStack(hilt), "SSS"," G ",'S', Items.stick, 'G', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(sharpeningblade), "F F","DFD"," D ", 'F', Items.flint, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(sharpeningblock), "S S","SCS","SSS",'S',Blocks.stone,'C',Items.clay_ball);
		for(SWORDTYPES sword : SWORDTYPES.values())
			GameRegistry.addRecipe(new ItemStack(sword.getSword()), " C ", " C ", " H ", 'C', sword.getCraftingMaterial(), 'H', hilt);
    }
	
	@EventHandler
    public void postInit (FMLPostInitializationEvent event){
        // postinit
		MinecraftForge.EVENT_BUS.register(evHandler);
    }
}
