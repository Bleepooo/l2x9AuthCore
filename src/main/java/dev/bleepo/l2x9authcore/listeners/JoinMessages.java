package dev.bleepo.l2x9authcore.listeners;

import dev.bleepo.l2x9authcore.Instance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinMessages implements Listener, Instance {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("Hide-Connection-Messages")) {
            e.setJoinMessage("");
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (plugin.getConfig().getBoolean("Hide-Connection-Messages")) {
            e.setQuitMessage("");
        }
    }
}
