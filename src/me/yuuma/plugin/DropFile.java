package me.yuuma.plugin;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.ItemStack;


public class DropFile {
	
	private MinerRpg plugin = MinerRpg.getPlugin(MinerRpg.class);
	private ConfigManager cfm = new ConfigManager();
	private int luck = 0;
	private File f;
	private FileConfiguration fc;
	
	public ItemStack getDrop(Player p,String Orename) {
		if(p.getInventory().getItemInMainHand() != null) {
			ItemStack item = p.getInventory().getItemInMainHand();
			if(item == null) {
				return null;
			}
			if(item.hasItemMeta()) { // Add Luck
				if(item.getItemMeta().hasLore()) {
					List<String> lore = item.getItemMeta().getLore();
					for(String line : lore) {
						String nocolor = ChatColor.stripColor(line);
						if(nocolor.replaceAll("[^a-zA-Z]", "").equalsIgnoreCase("Luck")) {
							luck += Integer.parseInt(nocolor.replaceAll("[^0-9]", ""));
						}
					}
				}
			}
			// Update Respawn fast in future **
		}

		getLuck(luck);
		
		ItemStack itemreturn = null;
		try {
			/* getItemDrop in File SavedItem in Myplugins
			if(Orename.equalsIgnoreCase("Gold")) {
				this.fc = cfm.getGold();
			}
			if(Orename.equalsIgnoreCase("Coal")) {
				this.fc = cfm.getCoal();
			}
			if(Orename.equalsIgnoreCase("Iron")) {
				this.fc = cfm.getIron();
			}
			if(Orename.equalsIgnoreCase("Emerald")) {
				this.fc = cfm.getEmerald();
			}
			if(Orename.equalsIgnoreCase("Diamond")) {
				this.fc = cfm.getDiamond();
			}
			if(Orename.equalsIgnoreCase("Lapis")) {
				this.fc = cfm.getLapis();
			}
			if(Orename.equalsIgnoreCase("Redstone")) {
				this.fc = cfm.getRedstone();
			}
			 */
			String getGem = "";
			if(luck < 1) {
				getGem = "V";
			} else if(luck < 5) {
				getGem = "IV";
			} else if(luck < 20) {
				getGem = "III";
			} else if(luck < 40) {
				getGem = "II";
			} else if(luck < 90) {
				getGem = "I";
			}
			this.fc = new YamlConfiguration();
			this.fc.load(new File(plugin.getDataFolder() + File.separator + Orename + ".yml"));
			itemreturn = this.fc.getItemStack(getGem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		luck = 0;
		
		return itemreturn;
	}
	
	public void getLuck(int l) {
		Random rm = new Random();
		int r = rm.nextInt(100) + 1;
		luck = r - l;
	}
	
}
