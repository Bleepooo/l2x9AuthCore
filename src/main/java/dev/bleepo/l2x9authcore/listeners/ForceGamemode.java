package dev.bleepo.l2x9authcore.listeners;

import dev.bleepo.l2x9authcore.Instance;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ForceGamemode implements Listener, Instance {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (config.getBoolean("Force-Gamemode")) {
            e.getPlayer().setGameMode(GameMode.valueOf(plugin.getConfig().getString("Gamemode").toUpperCase()));
        }
    }
}
