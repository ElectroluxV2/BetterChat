package me.mate.betterchat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;

public class Advanced {
	
    	// ```
    public static class SingleWord {
        String text;
        String color;
        Boolean italic;
        Boolean underline;
        Boolean bold;
        Boolean strikethrough;
        Boolean obfuscated;
    
        public SingleWord(String text, String color) {
            this.text = text;
            this.color = color;
            this.italic = false;
            this.underline = false;
            this.bold = false;
            this.strikethrough = false;
            this.obfuscated = false;
        }
       
        public SingleWord(String text, String color, Boolean italic, Boolean underline, Boolean bold, Boolean strikethrough, Boolean obfuscated) {
            this.text = text;
            this.color = color;
            this.italic = italic;
            this.underline = underline;
            this.bold = bold;
            this.strikethrough = strikethrough;
            this.obfuscated = obfuscated;
        }
       
        String getText(){
            return this.text;
        }
    
        String getColor(){
            return this.color;
        }
       
        Boolean getItalic(){
            return this.italic;
        }
       
        Boolean getUnderline(){
            return this.underline;
        }
       
        Boolean getBold(){
            return this.bold;
        }
       
        Boolean getStrikethrough(){
            return this.strikethrough;
        }
       
        Boolean getObfuscated(){
            return this.obfuscated;
        }
     
       
        void setText(String text){
            this.text = text;
        }
    
        void setColor(String color){
            this.color = color;
        }
       
        void setItalic(Boolean italic){
            this.italic = italic;
        }
       
        void setUnderline(Boolean underline){
            this.underline = underline;
        }
       
        void setBold(Boolean italic){
            this.italic = italic;
        }
       
        void setStrikethrough(Boolean strikethrough){
            this.strikethrough = strikethrough;
        }
       
        void setObfuscated(Boolean obfuscated){
            this.obfuscated = obfuscated;
        }
    }
    	
    public static String replaceChars(String str) {
    
        str = str.replaceAll(",","\u002C");
    	str = str.replaceAll("\"","❝");
    
    	return str;
    }
    
    public static void Start(final String m, final Player p){
        // Delete multi-spaces
        String message = m.trim().replaceAll(" +", " ");	
        // Split to words
        String[] words_S = message.split(" ");	
        // Create Object's array
        ArrayList<SingleWord> words = new ArrayList<SingleWord>();
        
        // To recognize quotes
        Boolean isInQuote = false;
    
        // Colors
        String online_color = Colors.toJson(Configs.getPlayersOnlineColor());
        String offline_color = Colors.toJson(Configs.getPlayersOfflineColor());
        String target_color = Colors.toJson(Configs.getPlayersTargetColor());
        String message_color = Colors.toJson(Configs.getMessagesColor());
        String quote_color = Colors.toJson(Configs.getQuotesColor());
        // Is quotes enabled?
        if(Configs.isQuotesColored()){
        	quote_color = message_color;
        }
    
        // Save words to objects
        for (int i = 0; i < words_S.length; i++) {
    	
            // Is quotes enabled?
            if(Configs.isQuotesEnabled()){
                if(words_S[i].contains(Configs.getQuotesChar())){
    		
                    // Count how many times quotes char exist
                    int counter = 0;
    
                    for( int ii=0; ii<words_S[i].length(); ii++ ) {
                        if( words_S[i].charAt(ii) == Configs.getQuotesChar().charAt(0) ) {
                            counter++;
                        } 
                    }
                    // If pairwise
                    if((counter & 1) == 0){
    	
                        // Add word to object with paramets		
                            words.add(i, new SingleWord(replaceChars(words_S[i]),quote_color,Configs.getQuotesItalic(), Configs.getQuotesUnderline(), Configs.getQuotesBold(), Configs.getQuotesStrikethrough(), Configs.getQuotesObfuscated()));
    	
                    } else {
    	
                        // Change value
                        if(isInQuote) isInQuote = false; else isInQuote = true;
                            // Add word to object with paramets	
                            words.add(i, new SingleWord(replaceChars(words_S[i]),quote_color,Configs.getQuotesItalic(), Configs.getQuotesUnderline(), Configs.getQuotesBold(), Configs.getQuotesStrikethrough(), Configs.getQuotesObfuscated()));      			
                        }
                    } else if(isInQuote){
                        // Add word to object with paramets	
                        words.add(i, new SingleWord(replaceChars(words_S[i]),quote_color,Configs.getQuotesItalic(), Configs.getQuotesUnderline(), Configs.getQuotesBold(), Configs.getQuotesStrikethrough(), Configs.getQuotesObfuscated()));
                    } else {
                        // Add normal word
                        words.add(i, new SingleWord(replaceChars(words_S[i]),message_color));
                    }  
                } else {
            // Add normal word
    		words.add(i, new SingleWord(replaceChars(words_S[i]),message_color));
    	}     	
    	System.out.println((words.get(i).getColor()));
    }
    
    // Loop by All players (Online and Offline)
    // Categorizing words for all players
    for(OfflinePlayer playerOffline : Bukkit.getOfflinePlayers()){
    	
        // Ain't Your Null
        if(playerOffline.getName()==null){
            continue;
        }
    
        // For loop trought words
        for (int i = 0; i < words.size(); i++) {
    	
            // Is it Interesting?
            // If contains players prefix?
            if(!words.get(i).getText().contains(Configs.getPlayersPrefix())){
                // TODO: czy jest może wielokropek, wykszyknik lub przecinek?
                //s.replaceAll("[^a-z0-9]", "");
    
                if(words.get(i).getText().toLowerCase().contains(((Configs.getPlayersPrefix() +playerOffline.getName().toLowerCase())))){
    	
                    // NickName SpellChecking?
                    if(Configs.isPlayersSpellChecking()){
                        words.get(i).setText(words.get(i).getText().replaceAll("(?i)" + Configs.getPlayersPrefix() + playerOffline.getName(), playerOffline.getName() + Colors.toColor(Configs.getMessagesColor())));					
                    }
    
                    // Change colors, efects, actions for Players Name
                        if(playerOffline.isOnline()){
        	
                            // Online enabled?
                            if(Configs.isPlayersOnlineEnabled()){
                                // Online color?
                                if(Configs.isPlayersOnlineColored()){
                                    // Set color
                                    words.get(i).setColor(online_color);
                                }
                            }	
                        } else {
    	
                            // Offline enabled?
                            if(Configs.isPlayersOfflineEnabled()){
                                // Offline color?
                                if(Configs.isPlayersOfflineColored()){
                                    // Set color
        						    words.get(i).setColor(offline_color);
            					}
            				}
            			}
            		}
            	}
            }
        }
            
        // Sender to all Online players
        for (Player playerOnline : Bukkit.getOnlinePlayers()) {
            	
            // Json, start
            String Json = "[\"\",";
            // For loop trought words
            for (int i = 0; i < words.size(); i++) {
                // Is Target Player Enabled?
                if(Configs.isPlayersTargetEnabled()){
                    // Substring the prefix
                    if(words.get(i).text.substring(Configs.getPlayersPrefix().length()).equalsIgnoreCase(playerOnline.getName())){
                    	Json += "{\"text\":\""+words.get(i).getText()+" \",\"color\":\""+target_color+"\",\"italic\":"+words.get(i).getItalic()+"},";
                    } else {
                    	// Add normal word
                        Json += "{\"text\":\""+words.get(i).getText()+" \",\"color\":\""+words.get(i).getColor()+"\",\"italic\":"+words.get(i).getItalic()+"},";
                	}
                } else {
                    // Add normal word
                    Json += "{\"text\":\""+words.get(i).getText()+" \",\"color\":\""+words.get(i).getColor()+"\",\"italic\":"+words.get(i).getItalic()+"},";
            	}					
            }
            // Json End, and delete last ,
            Json = Json.substring(0, Json.length() - 1);
            Json += "]";
                    
            // Sender's prefix
            TextComponent senderPrefix = new TextComponent((p.getDisplayName() + Colors.toColor(Configs.getMessagesColor()) + Configs.getMessagesSeparator()));
            // json to TextComponent
            System.out.println((Json));
            TextComponent messageFinished = new TextComponent(ComponentSerializer.parse(Json));
            
            // Send message to specific player
            playerOnline.spigot().sendMessage(senderPrefix ,messageFinished);
        }		
    }	
}
