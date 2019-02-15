package me.yuuma.plugin;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftMagicNumbers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.BukkitUtil;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import net.md_5.bungee.api.ChatColor;
public class MinerRpg extends JavaPlugin implements Listener,CommandExecutor {

	public static HashMap<Material, Integer> blockTime = new HashMap<Material, Integer>();
	public static HashMap<Location, Material> blockPlace = new HashMap<Location, Material>();
	public static List<String> Regions = new ArrayList<String>();
	public FileConfiguration config = new YamlConfiguration();
	public File cfile;
	public ConfigManager cfm;
	DropFile DropFile;
	
	@Override
	public void onEnable() {
		DropFile = new DropFile();
		loadConfigManager();
		getServer().getPluginManager().registerEvents(this, this);
		config = this.getConfig();
		getConfig().options().copyDefaults(true);
		saveConfig();
		cfile = new File(getDataFolder(), "config.yml");
		getCommand("MinerRpg").setExecutor(this);
		getRegions();
		getRespawnTime();
	}

	@Override
	public void onDisable() {

	}
	
	public void loadConfigManager() {
		cfm = new ConfigManager();
		cfm.setupCoal();
		cfm.setupDiamond();
		cfm.setupEmerald();
		cfm.setupGold();
		cfm.setupIron();
		cfm.setupLapis();
		cfm.setupRedstone();
		cfm.saveCoal();
		cfm.saveDiamond();
		cfm.saveEmerald();
		cfm.saveGold();
		cfm.saveIron();
		cfm.saveRedstone();
		cfm.saveLapis();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player p = (Player) sender;
		if(!p.isOp()) {
			return false;
		}
		if(args[0].equalsIgnoreCase("reload")) {
			config = YamlConfiguration.loadConfiguration(cfile);
			/*cfm.reloadCoal();
			cfm.reloadDiamond();
			cfm.reloadEmerald();
			cfm.reloadGold();
			cfm.reloadIron();
			cfm.reloadLapis();
			cfm.reloadRedstone();*/
			sender.sendMessage(ChatColor.GREEN + "MinerRPG Config has been reload");
			getRegions();
			getRespawnTime();	
		}
		return true;
	}

	public void setStrength(String configValue, Material material) {
		float valueOfStrength = (float) config.getConfigurationSection("Strength").getInt(configValue);
		if (valueOfStrength > 0) {
			try {
			  Field fl = net.minecraft.server.v1_12_R1.Block.class.getDeclaredField("strength");
			  fl.setAccessible(true); 
			  fl.setFloat(CraftMagicNumbers.getBlock(material),50.0f);
			  Field dl = net.minecraft.server.v1_12_R1.Block.class.getDeclaredField("durability");
			  dl.setAccessible(true); 
			  dl.setFloat(CraftMagicNumbers.getBlock(material),2000.0f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void getRegions() {
		if (config.getList("Regions").get(0) == null) {
			return;
		}
		Regions = (List<String>) config.getList("Regions");
	}

	public void getRespawnTime() {
		setRespawn("Coal", Material.COAL_ORE);
		setRespawn("Gold", Material.GOLD_ORE);
		setRespawn("Iron", Material.IRON_ORE);
		setRespawn("Diamond", Material.DIAMOND_ORE);
		setRespawn("Emerald", Material.EMERALD_ORE);
		setRespawn("Redstone", Material.REDSTONE_ORE);
		setRespawn("Lapis", Material.LAPIS_ORE);
	}

	public void setRespawn(String configValue, Material material) {
		if (config.getConfigurationSection("Regen Time").getInt(configValue) > 0) {
			blockTime.put(material, config.getConfigurationSection("Regen Time").getInt(configValue));
		}
	}
	
	
	
	public void setDrop() {
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(!p.isOp()) {
			if (isRegions(e.getBlock().getLocation())) {
				if(e.getBlock().getType().equals(Material.STONE)) {
					e.setCancelled(true);
					p.sendMessage(ChatColor.RED + "You can't break a block");
					return;
				}
			}
		}
		if (p.getGameMode().equals(GameMode.SURVIVAL)) {
			if (isRegions(e.getBlock().getLocation())) {
				if (blockTime.containsKey(e.getBlock().getType())) {
					Block b = e.getBlock();
					blockPlace.put(b.getLocation(), b.getType());
					e.setDropItems(false);
					String Orename = "";
					if(b.getType().equals(Material.GOLD_ORE)) {
						Orename = "Gold";
					}
					if(b.getType().equals(Material.COAL_ORE)) {
						Orename = "Coal";
					}
					if(b.getType().equals(Material.IRON_ORE)) {
						Orename = "Iron";
					}
					if(b.getType().equals(Material.LAPIS_ORE)) {
						Orename = "Lapis";
					}
					if(b.getType().equals(Material.DIAMOND_ORE)) {
						Orename = "Diamond";
					}
					if(b.getType().equals(Material.EMERALD_ORE)) {
						Orename = "Emerald";
					}
					if(b.getType().equals(Material.REDSTONE_ORE)) {
						Orename = "Redstone";
					}
					ItemStack drop = DropFile.getDrop(p, Orename);
					if(drop!=null) {
						Bukkit.getServer().getWorld(p.getWorld().getName())
						.dropItemNaturally(p.getLocation(),drop);
					}

					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						@Override
						public void run() {

							
					
							b.setType(Material.STONE);
						}
					}, 10);

					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						@Override
						public void run() {
							b.setType(blockPlace.get(b.getLocation()));
							blockPlace.remove(b.getLocation());
							p.sendMessage("BlockPlace");
						}

					}, blockTime.get(b.getType()) * 20);
				}
			}
		}
	}

	public boolean isRegions(Location l) {
		if (Regions == null) {
			return false;
		}
		/*
		 * if(wgpl.canBuild(p, p.getLocation())) { return false; }
		 */

		com.sk89q.worldedit.Vector vector = BukkitUtil.toVector(l);
		WorldGuardPlugin wgpl = WGBukkit.getPlugin();
		RegionManager rg = wgpl.getRegionManager(l.getWorld());
		ApplicableRegionSet set = rg.getApplicableRegions(vector);
		for (ProtectedRegion r : set) {
			for(int i=0;i<Regions.size();i++) {
				if (r.getId().equals(Regions.get(i))) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
