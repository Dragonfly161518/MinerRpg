package me.yuuma.plugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class ConfigManager {
	
	private MinerRpg plugin = MinerRpg.getPlugin(MinerRpg.class);
	
	public FileConfiguration CoalCf;
	public File CoalFile;
	
	public void setupCoal() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		CoalFile = new File(plugin.getDataFolder(), "Coal.yml");
		if(!CoalFile.exists()) {
			try {
				CoalFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Coal.yml");
			}
		}
		CoalCf = YamlConfiguration.loadConfiguration(CoalFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Coal.yml has been created");
	}
	public FileConfiguration getCoal() {
		return CoalCf;
	}
	public void saveCoal() {
		try {
			CoalCf.save(CoalFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Coal.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Coal.yml");
		}
	}
	public void reloadCoal() {
		CoalCf = YamlConfiguration.loadConfiguration(CoalFile);
	}
	//=========================================
	public FileConfiguration IronCf;
	public File IronFile;
	
	public void setupIron() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		IronFile = new File(plugin.getDataFolder(), "Iron.yml");
		if(!IronFile.exists()) {
			try {
				IronFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Iron.yml");
			}
		}
		IronCf = YamlConfiguration.loadConfiguration(IronFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Iron.yml has been created");
	}
	public FileConfiguration getIron() {
		return IronCf;
	}
	public void saveIron() {
		try {
			IronCf.save(IronFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Iron.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Iron.yml");
		}
	}
	public void reloadIron() {
		IronCf = YamlConfiguration.loadConfiguration(IronFile);
	}
	
	public FileConfiguration GoldCf;
	public File GoldFile;
	
	public void setupGold() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		GoldFile = new File(plugin.getDataFolder(), "Gold.yml");
		if(!GoldFile.exists()) {
			try {
				GoldFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Gold.yml");
			}
		}
		GoldCf = YamlConfiguration.loadConfiguration(GoldFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Gold.yml has been created");
	}
	public FileConfiguration getGold() {
		return GoldCf;
	}
	public void saveGold() {
		try {
			GoldCf.save(GoldFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Gold.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Gold.yml");
		}
	}
	public void reloadGold() {
		GoldCf = YamlConfiguration.loadConfiguration(GoldFile);
	}
	
	public FileConfiguration DiamondCf;
	public File DiamondFile;
	
	public void setupDiamond() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		DiamondFile = new File(plugin.getDataFolder(), "Diamond.yml");
		if(!DiamondFile.exists()) {
			try {
				DiamondFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Diamond.yml");
			}
		}
		DiamondCf = YamlConfiguration.loadConfiguration(DiamondFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Diamond.yml has been created");
	}
	public FileConfiguration getDiamond() {
		return DiamondCf;
	}
	public void saveDiamond() {
		try {
			DiamondCf.save(DiamondFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Diamond.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Diamond.yml");
		}
	}
	public void reloadDiamond() {
		DiamondCf = YamlConfiguration.loadConfiguration(DiamondFile);
	}
	
	public FileConfiguration EmeraldCf;
	public File EmeraldFile;
	
	public void setupEmerald() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		EmeraldFile = new File(plugin.getDataFolder(), "Emerald.yml");
		if(!EmeraldFile.exists()) {
			try {
				EmeraldFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Emerald.yml");
			}
		}
		EmeraldCf = YamlConfiguration.loadConfiguration(EmeraldFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Emerald.yml has been created");
	}
	public FileConfiguration getEmerald() {
		return EmeraldCf;
	}
	public void saveEmerald() {
		try {
			EmeraldCf.save(EmeraldFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Emerald.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Emerald.yml");
		}
	}
	public void reloadEmerald() {
		EmeraldCf = YamlConfiguration.loadConfiguration(EmeraldFile);
	}
	
	public FileConfiguration LapisCf;
	public File LapisFile;
	
	public void setupLapis() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		LapisFile = new File(plugin.getDataFolder(), "Lapis.yml");
		if(!LapisFile.exists()) {
			try {
				LapisFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Lapis.yml");
			}
		}
		LapisCf = YamlConfiguration.loadConfiguration(LapisFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Lapis.yml has been created");
	}
	public FileConfiguration getLapis() {
		return LapisCf;
	}
	public void saveLapis() {
		try {
			LapisCf.save(LapisFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Lapis.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Lapis.yml");
		}
	}
	public void reloadLapis() {
		LapisCf = YamlConfiguration.loadConfiguration(LapisFile);
	}
	
	public FileConfiguration RedstoneCf;
	public File RedstoneFile;
	
	public void setupRedstone() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		RedstoneFile = new File(plugin.getDataFolder(), "Redstone.yml");
		if(!RedstoneFile.exists()) {
			try {
				RedstoneFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Redstone.yml");
			}
		}
		RedstoneCf = YamlConfiguration.loadConfiguration(RedstoneFile);
		Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Redstone.yml has been created");
	}
	public FileConfiguration getRedstone() {
		return RedstoneCf;
	}
	public void saveRedstone() {
		try {
			RedstoneCf.save(RedstoneFile);
			Bukkit.getServer().getLogger().severe(ChatColor.GREEN + "The Redstone.yml has been saved");
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save Redstone.yml");
		}
	}
	public void reloadRedstone() {
		RedstoneCf = YamlConfiguration.loadConfiguration(RedstoneFile);
	}
}
