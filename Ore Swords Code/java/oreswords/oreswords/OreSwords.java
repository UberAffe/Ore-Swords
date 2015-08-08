package oreswords.oreswords;

import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import oreswords.items.Hilt;
import oreswords.items.OreSword;
import oreswords.items.OreSword.SWORDTYPES;
import oreswords.lib.RefStrings;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION, useMetadata = true)
public class OreSwords {
	
	@Instance(RefStrings.MODID)
    public static OreSwords instance;

	//@SidedProxy(clientSide = RefStrings.CLIENTPROXY, serverSide = RefStrings.SERVERPROXY)
    //public static CommonProxy proxy;	
	
	private Item hilt = new Hilt();
	
	@EventHandler
    public void preInit (FMLPreInitializationEvent event){
        // preinit
		for(SWORDTYPES sword : SWORDTYPES.values())
			GameRegistry.registerItem(new OreSword(sword), RefStrings.MODID + "_" + sword.getName());
		GameRegistry.registerItem(hilt, RefStrings.MODID + "_" + "hilt");
    }
	
	@EventHandler
    public void init (FMLInitializationEvent event){
        // init
		GameRegistry.addRecipe(new ItemStack(hilt), "   ","SSS"," G ",'S', Items.stick, 'G', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.COAL.getSword()), " C ", " C ", " H ", 'C', Blocks.coal_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.DIAMOND.getSword()), " C ", " C ", " H ", 'C', Blocks.diamond_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.EMERALD.getSword()), " C ", " C ", " H ", 'C', Blocks.emerald_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.GOLD.getSword()), " C ", " C ", " H ", 'C', Blocks.gold_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.IRON.getSword()), " C ", " C ", " H ", 'C', Blocks.iron_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.LAPIS.getSword()), " C ", " C ", " H ", 'C', Blocks.lapis_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.QUARTZ.getSword()), " C ", " C ", " H ", 'C', Blocks.quartz_ore, 'H', hilt);
		GameRegistry.addRecipe(new ItemStack(SWORDTYPES.REDSTONE.getSword()), " C ", " C ", " H ", 'C', Blocks.redstone_ore, 'H', hilt);
    }
	
	@EventHandler
    public void postInit (FMLPostInitializationEvent event){
        // postinit
    }
}
