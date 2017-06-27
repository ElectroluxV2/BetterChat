package me.mate.betterchat;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class Simple {

    public static void Start(final AsyncPlayerChatEvent e){
	
        // Message
        String message = e.getMessage();

        // Colors
        ChatColor online_color = Colors.toColor(Configs.getPlayersOnlineColor());
        ChatColor offline_color = Colors.toColor(Configs.getPlayersOnlineColor());
        ChatColor target_color = Colors.toColor(Configs.getPlayersTargetColor());
        ChatColor message_color = Colors.toColor(Configs.getMessagesColor());

        // Loop by All players (Online and Offline. This identify player names in message.
        for(OfflinePlayer playerOffline : Bukkit.getOfflinePlayers()){
	
        // Change all Names to Colors Offline and Online
        if(playerOffline.isOnline()){
	
            // Change nick color to online color
            message = message.replaceAll("(?i)\\" + Configs.getPlayersPrefix() + playerOffline.getName() + "\\b", online_color + Configs.getPlayersPrefix() + playerOffline.getName() + message_color);
        } else {
	
            // Change nick color to offline color
            message = message.replaceAll("(?i)\\" + Configs.getPlayersPrefix() + playerOffline.getName() + "\\b", offline_color + Configs.getPlayersPrefix() + playerOffline.getName() + message_color);
        }
    }

    // Send loop trough all online players
    for (Player playerOnline : Bukkit.getOnlinePlayers()) {
	
        // A copy to a specyfic player
        String message_to_send = message;

        // When it is target player
        if(message_to_send.toLowerCase().matches(".*\\" + online_color + Configs.getPlayersPrefix() + playerOnline.getName().toLowerCase() + message_color + "\\b.*")){
        	message_to_send = message_to_send.replace(online_color + Configs.getPlayersPrefix() + playerOnline.getName() + message_color, target_color + Configs.getPlayersPrefix() + playerOnline.getName() + message_color);
        }

        // Send
		playerOnline.sendMessage(e.getPlayer().getDisplayName() + message_color + Configs.getMessagesSeparator() + message_to_send);
	    }	
    }
}
