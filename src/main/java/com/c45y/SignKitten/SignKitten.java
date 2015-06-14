package com.c45y.SignKitten;

import java.util.logging.Level;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class SignKitten extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onSignChange(SignChangeEvent event) {
        for (String line : event.getLines()) {
            if (line != null && line.length() > 10000) {
                event.setCancelled(true);
                getLogger().log(Level.SEVERE, "Player {0} attempted to place a really strange sign", event.getPlayer().getName());
                return;
            }
        }
    }
}
