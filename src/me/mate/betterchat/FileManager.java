package me.mate.betterchat;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class FileManager {
	
private static YamlConfiguration msgYaml;
private static YamlConfiguration configYaml;
private static File users = new File(Main.getInst().getDataFolder(), "users");

    public static void checkFiles(){
    	
        // Główny folder
        if(!Main.getInst().getDataFolder().exists()){
        	Main.getInst().getDataFolder().mkdir();
        }
        
        // plik z wiadomościami
        File config = new File(Main.getInst().getDataFolder(), "config.yml");
        
        // Zapisz gdy nie istnieje
        if(!config.exists()){
        	Main.getInst().saveDefaultConfig();
        }
        
        // plik z wiadomościami
        File messages = new File(Main.getInst().getDataFolder(), "messages.yml");
        
        // Zapisz gdy nie istnieje
        if(!messages.exists()){
    	    Main.getInst().saveResource("messages.yml", true);
        }
        
        // Folder z Userami, Zapisz gdy nie istnieje
        if(!users.exists()){
        	users.mkdir();
        }
        
        msgYaml = YamlConfiguration.loadConfiguration(messages);
        configYaml = YamlConfiguration.loadConfiguration(config);
    }
    
    public static YamlConfiguration getMsgYaml(){
        return msgYaml;
    }
    
    public static YamlConfiguration getconfigYaml(){
        return configYaml;
    }
    
    public static File getPlayerFile(Player p){
        File f = new File(users, p.getName() + ".yml");
        if(!f.exists()) return null;
        return f;
    }
    
    public static File getUsersFolder(){
        return users;
    }
}
