package dev.bleepo.l2x9authcore.listeners;

import dev.bleepo.l2x9authcore.Instance;
import dev.bleepo.l2x9authcore.utils.Util;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class FreezePlayer extends Util implements Listener, Instance {
    @EventHandler
    public void onPlayerSpawn(PlayerRespawnEvent e) {
        if (config.getBoolean("Freeze")) {
            e.setRespawnLocation(lockloc());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (config.getBoolean("Freeze")) {
            e.getPlayer().teleport(lockloc());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (config.getBoolean("Freeze")) {
            e.setCancelled(true);
        }
    }

    private Location lockloc() {
        if (plugin.getServer().getWorld(config.getString("World")) == null) {
            sendWarning("Invalid World Name! Please Check the configuration file.");
            return null;
        }
        return new Location(plugin.getServer().getWorld(config.getString("World")), config.getInt("X"), config.getInt("Y"), config.getInt("Z"));
    }
}
