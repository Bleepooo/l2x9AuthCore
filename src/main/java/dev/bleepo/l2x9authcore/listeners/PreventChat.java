package dev.bleepo.l2x9authcore.listeners;

import dev.bleepo.l2x9authcore.Instance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PreventChat implements Listener, Instance {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (config.getBoolean("Crevent-chat")) {
            e.setCancelled(true);
        }
    }
}
