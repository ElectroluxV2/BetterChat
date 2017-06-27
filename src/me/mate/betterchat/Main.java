package me.mate.betterchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	// Instance 
	private static Main instance;
	
	public void onEnable(){
		
		// Instance 
		instance = this;
		
		// Eventy
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		
		// Komendy: betterchat
		getCommand("betterchat").setExecutor(new Commands());
		// Komendy: bt
		getCommand("bt").setExecutor(new Commands());
        
		// Files
		FileManager.checkFiles();
		
		// Load configuration
		Configs.load();
		

	}
	public void onDisable(){}
	
	public static Main getInst() {
		return instance;
	}
}
