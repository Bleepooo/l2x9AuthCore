package dev.bleepo.l2x9authcore.listeners;

import dev.bleepo.l2x9authcore.Instance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class HidePlayer implements Listener, Instance {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (config.getBoolean("Hide-Players")) {
            for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()) {
                e.getPlayer().hidePlayer(plugin, onlinePlayer);
                onlinePlayer.hidePlayer(plugin, e.getPlayer());
            }
        }
    }
}
