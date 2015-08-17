package oreswords.effects;

public enum SWORDEFFECTS {

	COAL(new CoalEffect()),//oreswords_coalsword
	DIAMOND(null),//oreswords_diamondsword
	EMERALD(null),//oreswords_emeraldsword
	GOLD(null),//oreswords_goldsword
	IRON(null),//oreswords_ironsword
	LAPIS(null),//oreswords_lapissword
	QUARTZ(null),//oreswords_quartzsword
	REDSTONE(null);//oreswords_redstonesword	
	
	public SwordEffect effect;
	SWORDEFFECTS(SwordEffect effect)
	{
		this.effect = effect;
	}	
}
