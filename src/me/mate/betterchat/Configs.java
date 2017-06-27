package me.mate.betterchat;

import org.bukkit.configuration.file.YamlConfiguration;

public class Configs {

    /* Root section */
    private static Boolean enable;
    private static Boolean advanced_mode;
    
    /* Messages section */
    private static Boolean messages_enabled;
    private static String messages_separator;
    private static String messages_color;
    
    /* Quotes section */
    private static Boolean quotes_enabled;
    private static String quotes_char;
    private static String quotes_char_to;
    private static Boolean quotes_colored;
    private static String quotes_color;
    private static Boolean quotes_italic;
    private static Boolean quotes_underline;
    private static Boolean quotes_bold;
    private static Boolean quotes_strikethrough;
    private static Boolean quotes_obfuscated;
    
    /* Players section */
    private static Boolean players_enabled;
    private static String players_prefix;
    private static Boolean players_spellchecking;
    // Online
    private static Boolean players_online_enabled;
    private static Boolean players_online_colored;
    private static String players_online_color;
    // Offline
    private static Boolean players_offline_enabled;
    private static Boolean players_offline_colored;
    private static String players_offline_color;
    // Offline
    private static Boolean players_target_enabled;
    private static Boolean players_target_colored;
    private static String players_target_color;


    public static void load(){
    	
    	// Give me Yaml
        YamlConfiguration yaml = FileManager.getconfigYaml();
        
        /* Root section */
        advanced_mode = yaml.getBoolean("advanced-mode-enable");
        enable = yaml.getBoolean("enable");
        
        /* Messages section */
        messages_enabled = yaml.getBoolean("messages.enabled");
        messages_separator = yaml.getString("messages.separator");
        messages_color = yaml.getString("messages.color");
        
        /* Quotes section */
        quotes_enabled = yaml.getBoolean("quotes.enabled");
        quotes_char = yaml.getString("quotes.char");
        quotes_char_to = yaml.getString("quotes.char-to");
        quotes_colored = yaml.getBoolean("quotes.colored");
        quotes_color = yaml.getString("quotes.color");
        quotes_italic = yaml.getBoolean("quotes.italic");
        quotes_underline = yaml.getBoolean("quotes.underline");
        quotes_bold = yaml.getBoolean("quotes.bold");
        quotes_strikethrough = yaml.getBoolean("quotes.strikethrough");
        quotes_obfuscated = yaml.getBoolean("quotes.obfuscated");
        
        /* Players section */
        players_enabled = yaml.getBoolean("players.enabled");
        players_prefix = yaml.getString("players.prefix");
        players_spellchecking = yaml.getBoolean("players.spell-checking");
        // Online
        players_online_enabled = yaml.getBoolean("players.online.enabled");
        players_online_colored = yaml.getBoolean("players.online.colored");
        players_online_color = yaml.getString("players.online.color");
        // Offline
        players_offline_enabled = yaml.getBoolean("players.offline.enabled");
        players_offline_colored = yaml.getBoolean("players.offline.colored");
        players_offline_color = yaml.getString("players.offline.color");
        // Target
        players_target_enabled = yaml.getBoolean("players.target.enabled");
        players_target_colored = yaml.getBoolean("players.target.colored");
        players_target_color = yaml.getString("players.target.color");
    }

    /* Root section */
    public static Boolean isAdvancedMode(){
        return advanced_mode;
    }
    
    public static Boolean isEnabled(){
        return enable;
    }
    
    /* Messages section */
    public static Boolean isMessagesEnabled(){	
        return messages_enabled;
    }
    
    public static String getMessagesSeparator(){
        return messages_separator;
    }
    
    public static String getMessagesColor(){
        return messages_color;
    }
    
    /* Quotes section */
    public static Boolean isQuotesEnabled(){	
        return quotes_enabled;
    }
    
    public static String getQuotesChar(){	
        return quotes_char;
    }
    
    public static String getQuotesCharTo(){	
        return quotes_char_to;
    }
    
    public static Boolean isQuotesColored(){	
        return quotes_colored;
    }
    
    public static String getQuotesColor(){	
        return quotes_color;
    }
    
    public static Boolean getQuotesItalic(){	
        return quotes_italic;
    }
    
    public static Boolean getQuotesUnderline(){	
        return quotes_underline;
    }
    
    public static Boolean getQuotesBold(){	
        return quotes_bold;
    }
    
    public static Boolean getQuotesStrikethrough(){	
        return quotes_strikethrough;
    }
    
    public static Boolean getQuotesObfuscated(){	
        return quotes_obfuscated;
    }
    
    /* Players section */
    public static Boolean isPlayersEnabled(){	
        return players_enabled;
    }
    
    public static String getPlayersPrefix(){	
        return players_prefix;
    }
    
    public static Boolean isPlayersSpellChecking(){	
        return players_spellchecking;
    }
    
    // Online
    public static Boolean isPlayersOnlineEnabled(){	
        return players_online_enabled;
    }
    
    public static Boolean isPlayersOnlineColored(){	
        return players_online_colored;
    }
    
    public static String getPlayersOnlineColor(){
        return players_online_color;
    }
    // offline
    public static Boolean isPlayersOfflineEnabled(){
        return players_offline_enabled;
    }
    
    public static Boolean isPlayersOfflineColored(){
        return players_offline_colored;
    }
    
    public static String getPlayersOfflineColor(){
        return players_offline_color;
    }
    // target
    public static Boolean isPlayersTargetEnabled(){
        return players_target_enabled;
    }
    
    public static Boolean isPlayersTargetColored(){
        return players_target_colored;
    }
    
    public static String getPlayersTargetColor(){
        return players_target_color;
    }
}
