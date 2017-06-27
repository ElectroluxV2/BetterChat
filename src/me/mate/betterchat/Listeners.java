package me.mate.betterchat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Listeners implements Listener{
	
	@EventHandler
	public void messageSend(final AsyncPlayerChatEvent e){
		// Is plugin enabled?
		if(!Configs.isEnabled()){
			return;
		}
		
		// Do not send orginal message
		e.setCancelled(true);
		
		// Async
		Bukkit.getScheduler().runTaskAsynchronously(Main.getInst(), new Runnable() {
			@Override
			public void run() {		
				// Witch one is enabled?
				if(Configs.isAdvancedMode()){
					Advanced.Start(e.getMessage(), e.getPlayer());
				} else {
					Simple.Start(e);
				}
			}
		});	
	}
}
